package com.uaf.pay.service.impl;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.aipg.common.AipgReq;
import com.aipg.common.AipgRsp;
import com.aipg.common.XSUtil;
import com.aipg.payresp.Body;
import com.aipg.payresp.Ret_Detail;
import com.aipg.transquery.QTDetail;
import com.aipg.transquery.QTransRsp;
import com.allinpay.XmlTools;
import com.uaf.pay.constants.ConfigKeyConstants;
import com.uaf.pay.constants.TranxCon;
import com.uaf.pay.dao.CommonDao;
import com.uaf.pay.dao.TranxDao;
import com.uaf.pay.dto.AIPTranxReqDetailDto;
import com.uaf.pay.dto.AIPTranxReqDto;
import com.uaf.pay.exception.AIPTranxServiceException;
import com.uaf.pay.model.BatchProcess;
import com.uaf.pay.model.BatchProcessDetail;
import com.uaf.pay.model.BatchQuery;
import com.uaf.pay.model.BatchQueryDetail;
import com.uaf.pay.model.Transaction;
import com.uaf.pay.service.AIPTranxService;
import com.uaf.pay.status.TransactionStatus;
import com.uaf.pay.support.TranxAssembler;
import com.uaf.pay.util.FileUtil;

/**
 */
public class AIPTranxServiceImpl implements AIPTranxService {

	private static Logger log = Logger.getLogger(AIPTranxServiceImpl.class);
	
	private TranxDao tranxDao;
	
	private CommonDao commonDao;

	
	public String sendXml(String xml,String url,boolean isFront, String tltcerPath) throws UnsupportedEncodingException, Exception{
		if(log.isDebugEnabled()) {
		    log.debug("======================发送报文======================：\n"+xml);
		}
		
		String resp=XmlTools.send(url,new String(xml.getBytes(), TranxCon.ENCODING_UTF_8));
		
		if(log.isDebugEnabled()) {
		    log.debug("======================响应内容======================: \n" + resp);
		}

		boolean flag= this.verifyMsg(resp, tltcerPath, isFront);
		if(flag){
			log.warn("响应内容验证通过");
		}else{
			log.warn("响应内容验证不通过");
		}
		
		return resp;
		
	}
	
	/**
	 * 验证签名
	 * @param msg
	 * @return
	 *日期：Sep 9, 2012
	 * @throws Exception 
	 */
	public boolean verifyMsg(String msg,String cer,boolean isFront) throws Exception{
		boolean flag=XmlTools.verifySign(msg, cer, false,isFront);
		if(log.isDebugEnabled()) {
		    log.debug("验签结果["+flag+"]") ;
		}
		
		return flag;
	}
	/**
	 * 通联有处理完成的transaction,会调用此通知接口
	 */
	@Transactional  
	public void queryTrade(String sn)throws Exception{
		List<BatchProcess> batchProcessList  = commonDao.getSqlSessionTemplate().selectList("com.uaf.pay.model.mapper.BatchProcessMapper.queryBatchProcessBySn", sn);
		queryAllInPayTransaction( batchProcessList);
	}

	@Transactional  
	public void queryTrade() throws Exception{
		
		//得到所有 2  发送响应成功的批次记录
		Map<String,Object> params = new HashMap<String,Object>();
		List<String> statusList = new ArrayList<String>();
		statusList.add("1");//1  已发送报文 
		statusList.add("2");//2  发送响应成功
		params.put("status", statusList);
				
		List<BatchProcess> batchProcessList = commonDao.getSqlSessionTemplate().selectList("com.uaf.pay.model.mapper.BatchProcessMapper.queryBatchProcess",params);
		queryAllInPayTransaction( batchProcessList);
	}

	private void queryAllInPayTransaction(List<BatchProcess> batchProcessList) throws Exception{
		
		if(batchProcessList != null && batchProcessList.size()>0){
			//send query XML 	
			Map<String, String> configMap = tranxDao.queryConfigInfo();
			
			for(BatchProcess batchProcess : batchProcessList){
				List<BatchProcessDetail> detailList  = commonDao.getSqlSessionTemplate().selectList("com.uaf.pay.model.mapper.BatchProcessDetailMapper.queryBatchProcessDetailByUpBatchProcessOid",batchProcess.getUpBatchProcessOid());
				
				log.debug(" #### start handle the query transactions");
				log.debug("处理的 Transaction 总数["+detailList.size()+"]");
				if(detailList != null && detailList.size()>0){
					//reqSn+sn --> up_transaction_oid
					Map<String, Long> transMap = buildTransMap(batchProcess.getReqSn(),detailList);
					
					String queryReqSn = batchProcess.getReqSn();
					log.info(">>>>>>>>>> query REQ_SN   "+queryReqSn);
		    		
					AipgReq aipgReq = TranxAssembler.assembleQueryTradeReq(queryReqSn,configMap);
					
					try{
						String xml=XmlTools.buildXml(aipgReq,true);
						String classLoadPath = FileUtil.getClassLoadPath();
						String pathPfx = classLoadPath + configMap.get(ConfigKeyConstants.AIPG_XMLMSG_TRANS_COMMON_BATCH_PFXPATH);
					    String passPfx = configMap.get(ConfigKeyConstants.AIPG_XMLMSG_TRANS_COMMON_BATCH_PFXPASSWORD);
					       
					    xml = XmlTools.signMsg(xml, pathPfx, passPfx, false);
					    String aipTranUrl = configMap.get(ConfigKeyConstants.AIPG_XMLMSG_TRANS_COMMON_BATCH_TRAN_URL);
					    String tltcerPath = classLoadPath + configMap.get(ConfigKeyConstants.AIPG_XMLMSG_TRANS_COMMON_BATCH_TLTCERPATH);
					    String resp = sendXml(xml,aipTranUrl,false, tltcerPath);
						
						//handle the return XML
						dealQuery(batchProcess.getUpBatchProcessOid(), transMap, aipgReq.getINFO().getREQ_SN(), resp,configMap,detailList.size());
					} catch (Exception e) {
						log.info(" >>>>>>>>>>>>> error "+e.getMessage()+e.getStackTrace());		
						throw e;
					}
					
					
				log.debug(" #### end handle the query transactions");
				}
			}
		}
	}



	private void dealQuery(Long upBatchProcessOid,
			Map<String, Long> transMap, String reqSn, String resp,Map<String, String> configMap,int transCount) {
		
		if(resp != null){
			// 写文件
			String fileFullName = saveBatchQueryFile(reqSn, resp, configMap);
			
			String trxCode =configMap.get(ConfigKeyConstants.AIPG_XMLMSG_TRANS_INFO_QUERY_TRX_CODE);
			AipgRsp aipgrsp=XSUtil.xmlRsp(resp);
			if(trxCode.equals(aipgrsp.getINFO().getTRX_CODE())){
				//insert up_batch_query.
				Date currDate = new Date();
				BatchQuery batchQuery = insertBatchQuery(reqSn,upBatchProcessOid, aipgrsp, currDate,fileFullName);
				//如果返回的状态不是中间的状态，则更新数据
				String retCode = aipgrsp.getINFO().getRET_CODE();
				log.info(" 通联返回的代码 return code ["+retCode+"]");
				if(TranxCon.RET_CODE_SUCESS.equals(retCode)){
					
					//insert up_batch_query_detail
					QTransRsp qrsq=(QTransRsp) aipgrsp.getTrxData().get(0);
					List<QTDetail> details=qrsq.getDetails();
					//update up_batch_process set the status = 4  查询成功
					//如果返回的transaction数量是全部的，那么更新状态为已经查询成功，不再继续查询
					//如果返回的transaction数量比整个批次少，那说明还有未完成的transaction,不做更新还要继续查询。
					//如果下次继续查询返回全部的数量,则更新整个批次的状态为查询成功。
					if(transCount==details.size()){
						log.info(" 更新up_batch_process的status为4 已经查询成功");
						updateBatchProcessStatus( upBatchProcessOid,TranxCon.BATCH_STATUS_QUERY_SUCESS);
					}
					if(details != null && details.size()>0){
						insertBatchQueryDetail( transMap,currDate, batchQuery,details);
					}
				} else if ("2000".equals(retCode) || "2001".equals(retCode)
						|| "2003".equals(retCode) || "2005".equals(retCode)
						|| "2007".equals(retCode) || "2008".equals(retCode)) {
					//2000		系统正在对数据处理					中间状态
					//2001		等待商户审核			中间状态
					//2003		等待	受理		中间状态
					//2005		等待	复核		中间状态
					//2007		提交银行处理			中间状态
					//2008		实时交易超时	(中间状态,需要查询)
					//如果是中间状态，不更新up_batch_process 的状态，下次继续查询。
	                log.info("返回代码说明:"+retCode+"  ");
	                log.info("返回错误信息："+aipgrsp.getINFO().getERR_MSG());
				} else if ("2004".equals(retCode) || "2006".equals(retCode)
						|| "2002".equals(retCode) || "0002".equals(retCode)
						|| "0001".equals(retCode) || "1999".equals(retCode)){
					//2004	不通过受理	最终失败
					//2006	不通过复核	最终失败
					//2002	商户审核不通过	最终失败
					//0002	已撤销	表示最终失败
					//0001	系统处理失败	表示最终失败
					//1999	本批交易已经全部失败(	最终结果)
	            	log.info("整批交易未受理通过（最终失败）");
	            	//更新transaction的状态
	            	List<Long> oidList = new ArrayList<Long>(transMap.values());
	            	updateTransactionStatus(oidList,TransactionStatus.TRANSACTION_FAILS);
	            	updateBatchProcessStatus( upBatchProcessOid,TranxCon.BATCH_STATUS_FAIL);
	            	
	            }else if("1002".equals(retCode)){
	            	log.info("无查询结果（该查询条件下，无法查到结果集）");
	            	//更新transaction的状态为3需要重新发送，需要重新发送交易到通联
	            	List<Long> oidList = new ArrayList<Long>(transMap.values());
	            	updateTransactionStatus(oidList,TransactionStatus.RESENDS);
	            	updateBatchProcessStatus( upBatchProcessOid,TranxCon.BATCH_STATUS_FAIL);
	            	
	            }else{
	            	log.info("查询请求失败，请重新发起查询");
	            }
			}
		}
	}
	

	private String saveBatchQueryFile(String reqSn, String resp,
			Map<String, String> configMap) {
		DateFormat dateFormat = new SimpleDateFormat(TranxCon.FILE_PATH_DATE_PATTERN);
		String strDate = dateFormat.format(new Date());
		String configuredPath = configMap.get(ConfigKeyConstants.AIPG_XMLMSG_TRANS_QUERY_BATCH_FILE_PATH);
		
		StringBuffer fileFullPath = new StringBuffer();
		String systemPathSeparator = System.getProperty(TranxCon.FILE_SEPARATOR);
		String fileSeparator =  systemPathSeparator!= null? systemPathSeparator : TranxCon.PATH_SEPARATOR;
		fileFullPath.append(configuredPath).append(fileSeparator).append(strDate);
		FileUtil.creatIfNotExsit(fileFullPath.toString());
		
		fileFullPath.append(fileSeparator).append(reqSn).append(TranxCon.XML_FILE_NAME);
		
		String fileFullName = fileFullPath.toString();
		if(log.isDebugEnabled()) {
			log.debug(" query fileFullName : " + fileFullName);
		}
		
		FileUtil.saveToFile(resp, fileFullName, TranxCon.ENCODING_UTF_8);
		
		return fileFullName;
	}
	
	private void insertBatchQueryDetail( Map<String, Long> transMap,
			Date currDate, BatchQuery batchQuery,  List<QTDetail> details) {
		//定义处理成功的 successTrsList
		List<Long> successTrsList = new ArrayList<Long>();
		//定义处理失败的 failTrsList
		List<Long> failTrsList = new ArrayList<Long>();	
		log.debug("返回的 Transaction 总数：["+details.size()+"]");
		List<String> successRetCodeList = Arrays.asList(TranxCon.DETAIL_RET_CODE_SUCESS);
		for(QTDetail tqDetail :details ){
			String batchId = tqDetail.getBATCHID();
			String sn = tqDetail.getSN();
			String key = batchId+sn;
			Long transactionOid = transMap.get(key);
			log.debug(" key-->"+key+" value-->"+transactionOid+"\t["+tqDetail.getRET_CODE()+"]");
			//处理成功 0000,0004是处理成功的
			if(successRetCodeList.contains(tqDetail.getRET_CODE())){
				//更新 up_transaction 7  交易成功
				successTrsList.add(transactionOid);
			}else{
				//更新 up_transaction 8  失败交易
				failTrsList.add(transactionOid);
			}
			insertBatchQueryDetail( currDate,batchQuery, tqDetail,transactionOid);
		}
		//更新up_transaction表的状态
		log.debug("处理成功的Transactions ["+successTrsList+"]");
		log.debug("处理失败的Transactions ["+failTrsList+"]");
		updateTransactionStatus(successTrsList,TransactionStatus.TRANSACTION_SUCCESSFUL);
		updateTransactionStatus(failTrsList,TransactionStatus.TRANSACTION_FAILS);
		
	}

	private void updateTransactionStatus( List<Long> trsList,String status) {
		if(trsList!=null && trsList.size()>0){
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("oids",trsList );
			params.put("status", status);
			commonDao.getSqlSessionTemplate().update("com.uaf.pay.model.mapper.TransactionMapper.updateStatus",params);
		}
	}

	private Map<String, Long> buildTransMap(String queryReqSn,List<BatchProcessDetail> list) {
		Map<String,Long> transMap = new HashMap<String,Long>();
		for(BatchProcessDetail batchProcessDetail : list){
			String key = queryReqSn+batchProcessDetail.getSn();
			Long value = batchProcessDetail.getUpTransactionOid();
			transMap.put(key, value);
		}
		return transMap;
	}


	private void updateBatchProcessStatus( Long upBatchProcessOid,String status) {
		log.debug("update BatchProcess ["+upBatchProcessOid+"]"+" status ["+TranxCon.BATCH_STATUS_QUERY_SUCESS+"] ");
		BatchProcess batchProcess = new BatchProcess();
		batchProcess.setUpBatchProcessOid(upBatchProcessOid);
		batchProcess.setStatus(status);
		
		commonDao.getSqlSessionTemplate().update("com.uaf.pay.model.mapper.BatchProcessMapper.updateBatchProcessStatus",batchProcess);
	}


	private void insertBatchQueryDetail( Date currDate,
			BatchQuery batchQuery, QTDetail tqDetail, Long transactionOid) {
		log.debug("insert BatchQueryDetail >> transactionOid  ["+transactionOid+"]");
		BatchQueryDetail batchQueryDetail = new BatchQueryDetail();
		batchQueryDetail.setUpBatchQueryOid(batchQuery.getUpBatchQueryOid());
		batchQueryDetail.setUpTransactionOid(transactionOid);
		batchQueryDetail.setSn(tqDetail.getSN());
		batchQueryDetail.setTrxDir(tqDetail.getTRXDIR());
		batchQueryDetail.setSettday(tqDetail.getSETTDAY());
		batchQueryDetail.setFinishTime(tqDetail.getFINTIME());
		batchQueryDetail.setSubmitTime(tqDetail.getSUBMITTIME());
		batchQueryDetail.setAccountNo(tqDetail.getACCOUNT_NO());
		batchQueryDetail.setAccountName(tqDetail.getACCOUNT_NAME());
		if(tqDetail.getAMOUNT()!=null){
			batchQueryDetail.setAmount(new BigDecimal(tqDetail.getAMOUNT()));
		}
		batchQueryDetail.setCustUserId(tqDetail.getCUST_USERID());
		batchQueryDetail.setRemark(tqDetail.getREMARK());
		batchQueryDetail.setReturnCode(tqDetail.getRET_CODE());
		batchQueryDetail.setErrorMsg(tqDetail.getERR_MSG());
		batchQueryDetail.setCreateDate(currDate);
		//如果一个批次包含10条transaction,但查询的时候只返回5条记录，那么下次再查询的时候应该只新增这次的返回记录，已经返回的那5条transaction不新增。
		log.debug(" transactionOid ["+transactionOid+"]\t return code ["+tqDetail.getRET_CODE()+"]\t ErrorMsg ["+tqDetail.getERR_MSG()+"]");
		//查询同一批次是否存在相同的记录
		Map<String,Object> parameter = new HashMap<String,Object>();
		parameter.put("up_transaction_oid", transactionOid);
		parameter.put("up_batch_process_oid", batchQuery.getUpBatchProcessOid());
		int count = commonDao.getSqlSessionTemplate().selectOne("com.uaf.pay.model.mapper.BatchQueryDetailMapper.queryIsExistSameBatch", parameter);
		if(count == 0){
			//1.第一次查询
			//2.同一个批次发送多次
			int i = commonDao.getSqlSessionTemplate().insert("com.uaf.pay.model.mapper.BatchQueryDetailMapper.insert",batchQueryDetail);
			log.info("新增一条记录 up_batch_query_detail" + i);
		}else{
			//如果不是第一次查询，那么不用新增一条新的
			log.info(" up_batch_query_detail 中已经存在相同的 up_transaction  "+count);
		}
	}


	private BatchQuery insertBatchQuery(String reqSn,
			Long batchProcessOid, AipgRsp aipgrsp, Date currDate,String filePath) {
		log.debug("insert BatchQuery >> batchProcessOid ["+batchProcessOid+"]");
		BatchQuery batchQuery = new BatchQuery();
		batchQuery.setUpBatchProcessOid(batchProcessOid);
		batchQuery.setReqSn(reqSn);
		batchQuery.setReturnCode(aipgrsp.getINFO().getRET_CODE());
		batchQuery.setErrorMsg(aipgrsp.getINFO().getERR_MSG());
		batchQuery.setCreateDate(currDate);
		batchQuery.setFilePath(filePath);
		//save to DB
		commonDao.getSqlSessionTemplate().insert("com.uaf.pay.model.mapper.BatchQueryMapper.insert",batchQuery);
		return batchQuery;
	}
	
	private void sendBatchTranx(Map<String, String> configMap, List<Transaction> transactions, String tranCode) throws Exception {
	
		Map<String, String> aipBankCodeMap = commonDao.getAipgBankMapping();
		AIPTranxReqDto aipTranxReqDto = TranxAssembler.assembleAIPTranxReqDto(configMap, aipBankCodeMap, transactions, tranCode);
		String reqSn = aipTranxReqDto.getReqSN();
		AipgReq aipg = TranxAssembler.assembleAipgReq(aipTranxReqDto);
		//Turn the batch data to XML format
		String xml = XmlTools.buildXml(aipg,true);
		
		String classLoadPath = FileUtil.getClassLoadPath();
        String pathPfx = classLoadPath + configMap.get(ConfigKeyConstants.AIPG_XMLMSG_TRANS_COMMON_BATCH_PFXPATH);
        String passPfx = configMap.get(ConfigKeyConstants.AIPG_XMLMSG_TRANS_COMMON_BATCH_PFXPASSWORD);
        if(log.isDebugEnabled()) {
			log.debug("pathPfx: " + pathPfx);
		}
        //Sign the xml message
    	xml = XmlTools.signMsg(xml, pathPfx, passPfx, false);
    	
    	List<Long> oidList = new ArrayList<Long>();
		for(Transaction tran : transactions) {
			oidList.add(tran.getUpTransactionOid());
		}
		//Update the transactions status to sent
		tranxDao.updateTranxToSent(oidList);
    	
    	AipgRsp aipgRsp = null;
		try {

	    	String aipTranUrl = configMap.get(ConfigKeyConstants.AIPG_XMLMSG_TRANS_COMMON_BATCH_TRAN_URL);
	    	Assert.notNull(aipTranUrl, "The target URL must not null, it should be configured to DB first");
	    	if(log.isDebugEnabled()) {
				log.debug("aipTranUrl : " + aipTranUrl);
			}
	    	
	    	String tltcerPath = classLoadPath + configMap.get(ConfigKeyConstants.AIPG_XMLMSG_TRANS_COMMON_BATCH_TLTCERPATH);
	    	if(log.isDebugEnabled()) {
				log.debug("tltcerPath: " + tltcerPath);
			}
	    	
			String resp = sendXml(xml, aipTranUrl ,false, tltcerPath);
			aipgRsp = handleRsp(resp);
			
		} catch (Exception e) {
			AIPTranxServiceException aipTranServiceException = new AIPTranxServiceException(e);
			
			throw aipTranServiceException;
			
		} finally {
			if(xml != null) {
				String fileFullName = createFile(configMap, aipTranxReqDto, xml);
				
				if(aipgRsp == null) {
					log.warn("Transactions are sent, but no response returned! ");
				}
				
				//Update batch data to DB
				Long batchProcessOid = createBatchProcess(aipTranxReqDto, aipgRsp,  fileFullName, reqSn);
		    	createBatchProcessDetails(aipTranxReqDto, aipgRsp, batchProcessOid);

			}
		}		
	}
	
	private String createFile (Map<String, String> configMap, AIPTranxReqDto aipTranxReqDto, String xml) {

		DateFormat dateFormat = new SimpleDateFormat(TranxCon.FILE_PATH_DATE_PATTERN);
		String strDate = dateFormat.format(new Date());
		String configuredPath = configMap.get(ConfigKeyConstants.AIPG_XMLMSG_TRANS_COMMON_BATCH_FILE_PATH);
		if(StringUtils.isEmpty(configuredPath)) {
			log.warn("The file path for AIP transaction request file is null, need be configured to DB first!");
		}
		
		StringBuffer fileFullPath = new StringBuffer();
		String systemPathSeparator = System.getProperty(TranxCon.FILE_SEPARATOR);
		String fileSeparator =  systemPathSeparator!= null? systemPathSeparator : TranxCon.PATH_SEPARATOR;
		fileFullPath.append(configuredPath).append(fileSeparator).append(strDate);
		FileUtil.creatIfNotExsit(fileFullPath.toString());
		
		String reqSn = (aipTranxReqDto != null && aipTranxReqDto.getReqSN() != null)?aipTranxReqDto.getReqSN(): String.valueOf(System.currentTimeMillis());
		fileFullPath.append(fileSeparator).append(reqSn).append(TranxCon.XML_FILE_NAME);
		
		String fileFullName = fileFullPath.toString();
		if(log.isDebugEnabled()) {
			log.debug("fileFullName : " + fileFullName);
		}
		
		FileUtil.saveToFile(xml, fileFullName, TranxCon.ENCODING_UTF_8);
		
		return fileFullName;
	}
	
	private AipgRsp handleRsp(String retXml) {
		String trxcode = null;
		AipgRsp aipgrsp=null;
		//或者交易码
		if (retXml.indexOf("<TRX_CODE>") != -1)
		{
			int end = retXml.indexOf("</TRX_CODE>");
			int begin = end - 6;
			if (begin >= 0) trxcode = retXml.substring(begin, end);
		}
		aipgrsp=XSUtil.xmlRsp(retXml);
		
		if(TranxCon.AIP_TRX_CODE.equals(trxcode)){
			if(TranxCon.RET_CODE_SUCESS.equals(aipgrsp.getINFO().getRET_CODE())){
				if(log.isInfoEnabled()) {
				    log.info("受理成功，请在20分钟后进行10/每次的轮询");
				}
			}else{
				log.warn("受理失败，失败原因："+aipgrsp.getINFO().getERR_MSG());
			}
		}
		
		return aipgrsp;
	}
	
	private void createBatchProcessDetails(AIPTranxReqDto aipTranxReqDto, AipgRsp aipgrsp, 
			Long batchProcessOid) {

		Map<String, Ret_Detail> retDetailMap = new HashMap<String, Ret_Detail>();
		
		if(aipgrsp != null) {
			List trxDatas = aipgrsp.getTrxData();
			Body trxDataBody = null;
			List retDetails = null;
			if(!trxDatas.isEmpty()) {
				trxDataBody = (Body)trxDatas.get(0);
				retDetails = trxDataBody.getDetails();
			}
			if(retDetails != null && !retDetails.isEmpty()) {
				for(Object obj : retDetails) {
					Ret_Detail retDetail = (Ret_Detail) obj;
					String sn = retDetail.getSN();
					retDetailMap.put(sn, retDetail);
				}
			}
		}
		
		List<AIPTranxReqDetailDto> tranxDetails = aipTranxReqDto.getAipTranxReqDetailDtos();
		List<BatchProcessDetail> batchProcessDetails = new ArrayList<BatchProcessDetail> ();
		List<Long> sucessOids = new ArrayList<Long>();
		List<Long> failOids = new ArrayList<Long>();
		
		for(AIPTranxReqDetailDto tranxDetail : tranxDetails) {
			BatchProcessDetail batchProcessDetail = new BatchProcessDetail();
			
			String sn = tranxDetail.getSeqNo();
			Ret_Detail retDetail = retDetailMap.get(sn);

			batchProcessDetail.setUpBatchProcessOid(batchProcessOid);
			batchProcessDetail.setCreateDate(new Date());
			batchProcessDetail.setSn(sn);
			batchProcessDetail.setUpTransactionOid(tranxDetail.getUpTransactionOid());
			
			if(retDetail != null) {
				batchProcessDetail.setErrorMsg(retDetail.getERR_MSG());
				String returnCode = retDetail.getRET_CODE();
				batchProcessDetail.setReturnCode(returnCode);
				
				if(TranxCon.RET_CODE_SUCESS.equals(returnCode)) {
					sucessOids.add(tranxDetail.getUpTransactionOid());
				} else {
					failOids.add(tranxDetail.getUpTransactionOid());
				}
			}
			batchProcessDetails.add(batchProcessDetail);
		}
		
		if(!batchProcessDetails.isEmpty()) {
			tranxDao.insertBatchProcessDetail(batchProcessDetails);
	    	tranxDao.updateTranx(sucessOids, failOids);
		}
	}
	
	private Long createBatchProcess(AIPTranxReqDto aipTranxReqDto, AipgRsp aipgrsp, String filePath, String reqSn) {

		BatchProcess batchProcess = new BatchProcess();
		batchProcess.setCreateDate(new Date());
		batchProcess.setFilePath(filePath);
		String status = TranxCon.BATCH_STATUS_SENT;
		batchProcess.setStatus(status);
		String itemTotal = aipTranxReqDto.getTotalItem();
		if(itemTotal != null) {
		    batchProcess.setTotalItem(Long.valueOf(itemTotal));
		}
		String totalSum = aipTranxReqDto.getTotalSum();
		if(StringUtils.isNotEmpty(totalSum)) {
			BigDecimal totalSumDecimal = new BigDecimal(totalSum);
			totalSumDecimal = totalSumDecimal.setScale(2);
			totalSumDecimal = totalSumDecimal.divide(new BigDecimal(100));
		    batchProcess.setTotalSum(totalSumDecimal);
		}
		Long upBatchProcessOid = tranxDao.queryBatchProcessSeq();
		batchProcess.setUpBatchProcessOid(upBatchProcessOid);
		
		if(aipgrsp != null) {
			batchProcess.setErrorMsg(aipgrsp.getINFO().getERR_MSG());
			batchProcess.setReqSn(aipgrsp.getINFO().getREQ_SN());
			batchProcess.setReturnCode(aipgrsp.getINFO().getRET_CODE());
			String retCode = aipgrsp.getINFO().getRET_CODE();
			if(TranxCon.RET_CODE_SUCESS.equals(retCode)) {
				status = TranxCon.BATCH_STATUS_SUCESS;
			} else if(ArrayUtils.contains(TranxCon.RET_CODE_MIDDLE, retCode)) {
				status = TranxCon.BATCH_STATUS_SUCESS;
			} else {
				status = TranxCon.BATCH_STATUS_FAIL;
			}
			batchProcess.setStatus(status);
		} else {
			batchProcess.setReqSn(reqSn);
		}
		
		tranxDao.insertBatchProcess(batchProcess);
		 
		return upBatchProcessOid;
	}
	
	@Override
	@Transactional
	public void doCollection() throws Exception {
		Map<String, String> configMap = commonDao.getAllConfigInfo();
		
		String batchSizeStr = configMap.get(ConfigKeyConstants.AIPG_XMLMSG_TRANS_COMMON_BATCH_SIZE);
		Assert.notNull(batchSizeStr, "The batch size must not null, it should be configured to DB first");
		int batchSize = Integer.valueOf(batchSizeStr).intValue();
		if(log.isDebugEnabled()) {
			log.debug("Configured batch size: " + batchSize);
		}
		
		int startNum = 1;
		//Query collection transactions of a batch
		List<Transaction> transactions = tranxDao.queryCollections(startNum, batchSize);
		//transactions = enableCompleteBatch(transactions); //已经把这个逻辑实现到 SQL语句里面了
		if(log.isDebugEnabled()) {
			log.debug(" Final collection size = " + transactions.size());
		}
		if(transactions == null || transactions.isEmpty()) {
			log.info("No collection need be sent");
			return;
		}
		
		String tranCode = configMap.get(ConfigKeyConstants.AIPG_XMLMSG_TRANS_INFO_COLLECTION_TRX_CODE);
		
		
		sendBatchTranx(configMap,transactions,  tranCode);
		
	}
	
/*
* 在组装发送交易报批次时，为保证完整的 apply_code 支付，应删除末尾项， 由于不可确定它是否为完整  apply_code 的支付。
	 
	private List<Transaction> enableCompleteBatch(List<Transaction> list){
		
		if(list!=null && list.size()>0){
			log.info("---- enableCompleteBatch：input.list.size = "+ list.size() );
			List<Transaction> removeList = new ArrayList<Transaction>();
			Transaction firstTxn = list.get(0);
			Transaction lastTxn = list.get(list.size()-1);
			String applyID = lastTxn.getUfAppCode();
			if(applyID!=null && !applyID.equals(firstTxn.getUfAppCode())){
				log.info("---- we will remove last applyID = "+ applyID );
				removeList.add(lastTxn);
				for(int i=list.size()-1; i>=0; i--){
					Transaction txn = list.get(i);
					if(applyID.endsWith(txn.getUfAppCode())){
						removeList.add(txn);
					}else{
						break;
					}
				}
				
				list.removeAll(removeList);
			}
			log.info("---- enableCompleteBatch：return.list.size = "+ list.size() );
		}	
		return list;
	}
*/
	public void setTranxDao(TranxDao tranxDao) {
		this.tranxDao = tranxDao;
	}

	public void setCommonDao(CommonDao commonDao) {
		this.commonDao = commonDao;
	}

}
