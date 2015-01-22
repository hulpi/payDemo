package com.uaf.pay.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import com.uaf.pay.dao.Dao;
import com.uaf.pay.dto.AppLedgSeqIdDto;
import com.uaf.pay.dto.QueryTransactionDto;
import com.uaf.pay.dto.RequestTransactionBeans;
import com.uaf.pay.dto.TransactionBeans;
import com.uaf.pay.dto.TransactionDto;
import com.uaf.pay.dto.UiTransactionDTO;
import com.uaf.pay.model.Transaction;
import com.uaf.pay.service.TransactionService;
import com.uaf.pay.status.TransactionStatus;
import com.uaf.pay.util.XMLUtil;

public class TransactionServiceImpl implements TransactionService {
	Logger log = Logger.getLogger(TransactionServiceImpl.class);
	
	private Dao dao;

	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}
	

	public List<UiTransactionDTO> getAllinpayTransactions(
			QueryTransactionDto dto) {
		//prepare the query DTO.
		dto.setStatus(TransactionStatus.AUDITED);
		
		List<Transaction> trsList = dao.getSqlSessionTemplate().selectList("com.uaf.pay.model.mapper.TransactionMapper.queryTransactions",dto);
		
		List<UiTransactionDTO> uiList = new ArrayList<UiTransactionDTO>();
		if (trsList != null && trsList.size() > 0) {
			for (Transaction transaction : trsList) {
				UiTransactionDTO uiDto = new UiTransactionDTO();
				BeanUtils.copyProperties(transaction, uiDto);
				uiList.add(uiDto);
			}
		}
		return uiList;
	}

	public void updateAllinPayInfo(List<Long> transactionOids) {
		dao.getSqlSessionTemplate().update("com.uaf.pay.model.mapper.TransactionMapper.updateTransactionStatus",transactionOids);
	}

	/**
	 * add new transaction
	 * @throws Exception 
	 */
	public boolean addTransaction(String xmlStr) throws Exception {
		
		boolean isSave = true;
		log.info("################start add Transaction################");
		// convert to TransactionBeans
		log.info(" ---------------------------------------------------------------");
		log.info(xmlStr);
		log.info(" ---------------------------------------------------------------");
		TransactionBeans transBean = (TransactionBeans) XMLUtil.convertXmlStrToObject(TransactionBeans.class, xmlStr);
		Date currentDate = new Date();
		try {
			if (transBean != null && transBean.getTransList() != null) {

				List<TransactionDto> transList = transBean.getTransList();
				Map<String,Long> sysRegMap =getResultMap("com.uaf.pay.model.mapper.SysRegisterMapper.querySysRegister", "SYS_REGISTER_CODE", "UP_SYS_REGISTER_OID"); 
				log.info(" ------ system ID -----------" +transBean.getSystemId());
				Long upSysRegisterOid  = sysRegMap.get(transBean.getSystemId());
				if(upSysRegisterOid == null){
					throw new Exception("系统注册ID不正确！");
				}
				Map<String,Long> agentPayMap = getResultMap("com.uaf.pay.model.mapper.AgentPayMapper.queryAgentPay","AGENT_PAY_CODE","UP_AGENT_PAY_OID");
				Map<String,Long> merchantMap = getResultMap("com.uaf.pay.model.mapper.MerchantMapper.queryMerchant","CITY_CODE","UP_MERCHANT_OID");
				
				for (TransactionDto transactionDto : transList) {
					
					//validate the data is correct
					String sb = validateTransaction(transactionDto, agentPayMap, merchantMap);
			
					Transaction transaction = new Transaction();
					//upSysRegisterOid
					transaction.setUpSysRegisterOid(upSysRegisterOid);
					//ufAppLedgSeqId
					transaction.setUfAppLedgSeqId(transactionDto.getUfAppLedgSeqId());
					//ufSendBatchId
					transaction.setUfSendBatchId(transBean.getBatchNo());
					//ufAppCode
					transaction.setUfAppCode(transactionDto.getUfAppCode());
					//ufCityCode
					transaction.setUfCityCode(transactionDto.getUfCityCode());
					//upAgentPayOid
					transaction.setUpAgentPayOid(agentPayMap.get(transactionDto.getUpAgentPayCode()));
					//payType
					transaction.setPayType(transactionDto.getPayType());
					//upMerchantOid
					transaction.setUpMerchantOid(merchantMap.get(transactionDto.getUfCityCode()));
					//referenceNo
					transaction.setReferenceNo(transactionDto.getReferenceNo());
					//accountNo
					transaction.setAccountNo(transactionDto.getAccountNo());
					//accountName
					transaction.setAccountName(transactionDto.getAccountName());
					//accountCertType
					transaction.setAccountCertType(transactionDto.getAccountCertType());
					//bankCode
					transaction.setBankCode(transactionDto.getBankCode());
					//bankName
					transaction.setBankName(transactionDto.getBankName());
					//bankProvince
					transaction.setBankProvince(transactionDto.getBankProvince());
					//bankCity
					transaction.setBankCity(transactionDto.getBankCity());
					//settleType
					transaction.setSettleType(transactionDto.getSettleType());
					//amount
					transaction.setAmount(transactionDto.getAmount());
					//currency
					transaction.setCurrency(transactionDto.getCurrency());
					//expectSettleDate
					transaction.setExpectSettleDate(transactionDto.getExpectSettleDate());
					//actualSettleDate
					transaction.setActualSettleDate(transactionDto.getActualSettleDate());
					//versionNo
					transaction.setVersionNo(0);
					//createDate
					transaction.setCreateDate(currentDate);
					
					
					if(sb != null && sb.length()>0){
						log.info("数据不合法："+sb);
						transaction.setStatus(TransactionStatus.VALIDATE_FAIL);
						transaction.setRemark(sb);
					}else{
						transaction.setStatus(TransactionStatus.AUDITED);
					}

					// save to DB
					dao.getSqlSessionTemplate().insert("com.uaf.pay.model.mapper.TransactionMapper.insert",transaction);
					
					log.info("add new record successfully!");
				}
				
			}
		} catch (Exception e) {
			log.info("an error occurred while trying to add data"
					+ e.getMessage());
			isSave = false;
			throw e;
		}
		log.info("################End add Transaction################");
		return isSave;
	}
	
	private String validateTransaction(TransactionDto transactionDto,Map<String,Long> agentPayMap ,Map<String,Long>  merchantMap) throws ParseException{
		StringBuilder sb = new StringBuilder();
		
		String upAgentPayCode = transactionDto.getUpAgentPayCode();
		log.info("---------agent pay code--------------"+upAgentPayCode);
		Long agentPayOid = agentPayMap.get(upAgentPayCode);
		if(agentPayOid == null){
			sb.append(" agentPayOid 代理收付方OID 为空 ");
		}		
		
		
		String ufCityCode = transactionDto.getUfCityCode();
		log.info("---------city code--------------"+ufCityCode);
		Long merchantOid = merchantMap.get(ufCityCode);
		if(merchantOid == null){
			sb.append(" merchantOid 商户Oid为空 ");
		}
		
		
		//validate the  expectSettleDate  预期结算日期，不能小于当天
		Date expectSettleDate = transactionDto.getExpectSettleDate();
		DateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date currentdate = new Date();
		String str = sdf.format(currentdate);
		Date formatDate=sdf.parse(str);
		
		log.info("----------expectSettleDate----------"+expectSettleDate);
		if(expectSettleDate != null && expectSettleDate.compareTo(formatDate)<0){
			sb.append(" expectSettleDate 预期结算日期，不能小于当天  ");
		}
		
		//ufAppCode
		String ufAppCode = transactionDto.getUfAppCode();
		if(StringUtils.isEmpty(ufAppCode)){
			sb.append(" ufAppCode 申请人ID 为空  ");
		}
		
		//uf_app_ledg_seq_id
		String ufAppLedgSeqId = transactionDto.getUfAppLedgSeqId();
		log.info("----------ufAppLedgSeqId----------"+ufAppLedgSeqId);
		if(StringUtils.isEmpty(ufAppLedgSeqId)){
			sb.append(" ufAppLedgSeqId 业务支付ID为空  ");
		}
		return sb.toString();
	}
	

	@Override
	public String getTransaction(String xmlStr) {
		TransactionBeans transactionBeans = new TransactionBeans();
		RequestTransactionBeans requestBeans = (RequestTransactionBeans)XMLUtil.convertXmlStrToObject(RequestTransactionBeans.class, xmlStr);
		List<String> appLedgSeqlist = new ArrayList<String>();
		if(requestBeans != null && requestBeans.getAppLedgSeqIdList() != null){
			
			List<AppLedgSeqIdDto> appLedgSeqIdList = requestBeans.getAppLedgSeqIdList();
			
			for(AppLedgSeqIdDto appLedgSeqIdDto : appLedgSeqIdList){
				appLedgSeqlist.add(appLedgSeqIdDto.getUfAppLedgSeqId());
			}
		}
		
		if(appLedgSeqlist.size()== 0){
			return XMLUtil.convertToXml(transactionBeans);
		}
		
		List<TransactionDto> transDtoList = dao.getSqlSessionTemplate().selectList("com.uaf.pay.model.mapper.TransactionMapper.queryTransactionsByAppLedgSeqId",appLedgSeqlist);
		
		transactionBeans.setTransList(transDtoList);
		
		return XMLUtil.convertToXml(transactionBeans);
	}
	
	
	public Map<String,Long> getResultMap(String sql,final String mapKey,final String mapValue){
		final Map<String,Long> resultMap = new HashMap<String, Long>();
		dao.getSqlSessionTemplate().select(sql, new ResultHandler() {
			
			@Override
			public void handleResult(ResultContext resultcontext) {
				Map obj = (Map)resultcontext.getResultObject();
				String key = (String) obj.get(mapKey);
				Long value = Long.valueOf(obj.get(mapValue).toString());
				resultMap.put(key, value);
			}
		});
		return resultMap;
	}
	

}
