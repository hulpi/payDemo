package com.uaf.pay.support;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.aipg.common.AipgReq;
import com.aipg.common.InfoReq;
import com.aipg.payreq.Body;
import com.aipg.payreq.Trans_Detail;
import com.aipg.payreq.Trans_Sum;
import com.aipg.transquery.TransQueryReq;
import com.uaf.pay.constants.ConfigKeyConstants;
import com.uaf.pay.constants.TranxCon;
import com.uaf.pay.dto.AIPTranxReqDetailDto;
import com.uaf.pay.dto.AIPTranxReqDto;
import com.uaf.pay.dto.CMBBatchPaymentDto;
import com.uaf.pay.dto.CMBPaymentDetailDto;
import com.uaf.pay.dto.RfTransactionBatchDto;
import com.uaf.pay.dto.RfTransactionDto;
import com.uaf.pay.model.Transaction;

public class TranxAssembler {
	
	private static Logger log = Logger.getLogger(TranxAssembler.class);
	
	public static AIPTranxReqDto assembleAIPTranxReqDto(Map<String, String> configMap, Map<String, String> aipBankCodeMap,
			List<Transaction> transactions, String tranCode) {
		if(transactions == null || transactions.isEmpty()) {
			return null;
		}
		
		AIPTranxReqDto aipTranxReqDto = new AIPTranxReqDto();
		
		aipTranxReqDto.setTrxCode(tranCode);
		aipTranxReqDto.setVersion(configMap.get(ConfigKeyConstants.AIPG_XMLMSG_TRANS_INFO_VERSION));
		aipTranxReqDto.setDataType(configMap.get(TranxCon.XML_DATA_TYPE));
		aipTranxReqDto.setLevel(TranxCon.LEVEL_FIVE);
		aipTranxReqDto.setUserName(configMap.get(ConfigKeyConstants.AIPG_XMLMSG_TRANS_INFO_USER_NAME));
		aipTranxReqDto.setUserPass(configMap.get(ConfigKeyConstants.AIPG_XMLMSG_TRANS_INFO_USER_PASS));
		
		aipTranxReqDto.setBusinessCode(configMap.get(ConfigKeyConstants.AIPG_XMLMSG_TRANS_BODY_BUSSINESS_CODE));
		String merchantId = configMap.get(ConfigKeyConstants.AIPG_XMLMSG_TRANS_BODY_MERCHANT_ID);
		Assert.notNull(merchantId, "The MERCHANT_ID must not null, it should be configured to DB first");
		aipTranxReqDto.setMerchantId(merchantId);
		
		String reqSn = genReqSn(merchantId);
		if(log.isInfoEnabled()) {
		    log.info("The reqSn is: " + reqSn);
		}
		aipTranxReqDto.setReqSN(reqSn);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(TranxCon.SUBMIT_TIME_PATTERN);
		String submitTime = dateFormat.format(new Date());
		aipTranxReqDto.setSubmitTime(submitTime);
		
		int itemNumber = transactions.size();
		if(log.isInfoEnabled()) {
		    log.info("The items number is: " + itemNumber);
		}
		aipTranxReqDto.setTotalItem(String.valueOf(itemNumber));
		
		BigDecimal totalAmount = new BigDecimal(0);
		for(Transaction transaction : transactions) {
			BigDecimal amount = transaction.getAmount();
			amount = amount.multiply(new BigDecimal(100));
			totalAmount = totalAmount.add(amount);
		}
		
		int totalAmountInt= totalAmount.intValue();
		if(log.isDebugEnabled()) {
		    log.debug("Total amount = " + totalAmountInt);
		}
		aipTranxReqDto.setTotalSum(String.valueOf(totalAmountInt));
		
		int itemCount = 0;
		List<AIPTranxReqDetailDto> reqDetails = new ArrayList<AIPTranxReqDetailDto>();
		aipTranxReqDto.setAipTranxReqDetailDtos(reqDetails);
		
		for(Transaction tran : transactions) {
			itemCount ++;
			AIPTranxReqDetailDto aipTranxReqDetailDto = new AIPTranxReqDetailDto();
			aipTranxReqDetailDto.setUpTransactionOid(tran.getUpTransactionOid());
			aipTranxReqDetailDto.setSeqNo(String.valueOf(itemCount));
			String bankCode = aipBankCodeMap.get(tran.getBankCode());
			aipTranxReqDetailDto.setBankCode(bankCode);
			aipTranxReqDetailDto.setAccountName(tran.getAccountName());
			String accountProp = TranxCon.ACCOUNT_PROP_PRIVATE;
			if(TranxCon.ACCOUNT_PROP_CO.equals(tran.getAccountCertType()) ){
				accountProp = TranxCon.ACCOUNT_PROP_COMPANY;
			}
			aipTranxReqDetailDto.setAccountProp(accountProp);
			aipTranxReqDetailDto.setAccountNo(tran.getAccountNo());
			BigDecimal amount = tran.getAmount();
			if(amount != null && (amount.compareTo(new BigDecimal(0)) == 1)) {
				amount = amount.multiply(new BigDecimal(100));
				int intAmoutn = amount.intValue();
				aipTranxReqDetailDto.setAmount(String.valueOf(intAmoutn));
			}
			
			aipTranxReqDetailDto.setCurrency(tran.getCurrency());
			
			reqDetails.add(aipTranxReqDetailDto);
		}
		
		return aipTranxReqDto;
	}
	
	private static String genReqSn(String merchantId) {
		StringBuffer reqSnBuffer = new StringBuffer(40);
		reqSnBuffer.append(TranxCon.AIP_TRANX_REQ_SN_PREFIX);
		reqSnBuffer.append(merchantId);
		reqSnBuffer.append(System.currentTimeMillis());
		
		return reqSnBuffer.toString();
		
	}
	
	public static AipgReq assembleAipgReq(AIPTranxReqDto reqDto) {
		AipgReq aipg=new AipgReq();
		
		if(reqDto == null) {
			return aipg;
		}
		
		InfoReq info=assembleInfoReq(reqDto);
		aipg.setINFO(info);
		
		Body body = new Body();
		Trans_Sum trans_sum = new Trans_Sum() ;
		trans_sum.setBUSINESS_CODE(reqDto.getBusinessCode());
		trans_sum.setMERCHANT_ID(reqDto.getMerchantId());
		trans_sum.setSUBMIT_TIME(reqDto.getSubmitTime());
		trans_sum.setTOTAL_ITEM(reqDto.getTotalItem());
		trans_sum.setTOTAL_SUM(reqDto.getTotalSum());
		body.setTRANS_SUM(trans_sum);
		
		List<AIPTranxReqDetailDto> aipTranxReqDetailDtos = reqDto.getAipTranxReqDetailDtos();
		List <Trans_Detail>transDetails = new ArrayList<Trans_Detail>() ;
		
		if(aipTranxReqDetailDtos != null) {
			for(AIPTranxReqDetailDto reqDetailDto : aipTranxReqDetailDtos) {
				Trans_Detail trans_detail = new Trans_Detail();
				trans_detail.setSN(reqDetailDto.getSeqNo()) ;
		    	trans_detail.setACCOUNT_NAME(reqDetailDto.getAccountName()) ;
		 		trans_detail.setACCOUNT_PROP(reqDetailDto.getAccountProp());
				trans_detail.setACCOUNT_NO(reqDetailDto.getAccountNo()) ;
				trans_detail.setBANK_CODE(reqDetailDto.getBankCode()) ;
				trans_detail.setAMOUNT(reqDetailDto.getAmount()) ;
				trans_detail.setCURRENCY(reqDetailDto.getCurrency());
				trans_detail.setSETTGROUPFLAG(reqDetailDto.getSettGroupFlag());
				trans_detail.setSUMMARY(reqDetailDto.getSummary());
				trans_detail.setUNION_BANK(reqDetailDto.getUnionBank());
				
				transDetails.add(trans_detail) ;
			}
		}
		
        body.setDetails(transDetails) ;
        aipg.addTrx(body) ;
        
        return aipg;
		
	}
	
	private static InfoReq assembleInfoReq(AIPTranxReqDto reqDto) {
		InfoReq info=new InfoReq();
		
		info.setTRX_CODE(reqDto.getTrxCode());
		info.setREQ_SN(reqDto.getReqSN());
		info.setUSER_NAME(reqDto.getUserName());
		info.setUSER_PASS(reqDto.getUserPass());
		info.setMERCHANT_ID(reqDto.getMerchantId());
		info.setLEVEL(reqDto.getLevel());
		info.setDATA_TYPE(reqDto.getDataType());
		info.setVERSION(reqDto.getVersion());
		
		return info;
	}
	
	
	/**
	 * prepare query information
	 * @param batchProcessList
	 * @return
	 */
	public static AipgReq assembleQueryTradeReq(String reqSn,Map<String, String> configMap) {
		AipgReq aipgReq=new AipgReq();
		String merchantId = configMap.get(ConfigKeyConstants.AIPG_XMLMSG_TRANS_BODY_MERCHANT_ID);
		// prepare the query information
		InfoReq info = assembleQueryInfoReq(configMap);
		aipgReq.setINFO(info);

		TransQueryReq dr = new TransQueryReq();
		aipgReq.addTrx(dr);
		dr.setMERCHANT_ID(merchantId);// 商户代码
		dr.setQUERY_SN(reqSn);// 原请求交易中的REQ_SN
		dr.setSTATUS(2);// 交易状态条件，0 成功，1 失败，2全部，3退票
		dr.setTYPE(1);// 查询类型 0 按完成日期，1 按提交日期，
		dr.setSTART_DAY("");
		dr.setEND_DAY("");
			
		return aipgReq;
	}
	/**
	 * prepare the info
	 * @return
	 */
	public static InfoReq assembleQueryInfoReq(Map<String, String> configMap){
		InfoReq infoReq = new InfoReq();
		infoReq.setTRX_CODE(configMap.get(ConfigKeyConstants.AIPG_XMLMSG_TRANS_INFO_QUERY_TRX_CODE));
		infoReq.setVERSION(configMap.get(ConfigKeyConstants.AIPG_XMLMSG_TRANS_INFO_VERSION));
		infoReq.setDATA_TYPE(TranxCon.XML_DATA_TYPE);
		String merchantId = configMap.get(ConfigKeyConstants.AIPG_XMLMSG_TRANS_BODY_MERCHANT_ID);
		infoReq.setREQ_SN(genQueryReqSn(merchantId));
		infoReq.setUSER_NAME(configMap.get(ConfigKeyConstants.AIPG_XMLMSG_TRANS_INFO_USER_NAME));
		infoReq.setUSER_PASS(configMap.get(ConfigKeyConstants.AIPG_XMLMSG_TRANS_INFO_USER_PASS));
		
		infoReq.setSIGNED_MSG("");
		infoReq.setMERCHANT_ID(merchantId);
		infoReq.setLEVEL(TranxCon.LEVEL_FIVE);
		
		return infoReq;
	}
	
	private static String genQueryReqSn(String merchantId) {
		StringBuffer reqSnBuffer = new StringBuffer(40);
		reqSnBuffer.append(TranxCon.AIP_TRANX_QUERY_REQ_SN_PREFIX);
		reqSnBuffer.append(merchantId);
		reqSnBuffer.append(System.currentTimeMillis());
		
		return reqSnBuffer.toString();
		
	}
	
	public List<CMBBatchPaymentDto> assembleCMBPaymentDto (String cityCode, List<Transaction> transactions, String dbtAcc) {
		if(transactions == null || transactions.isEmpty()) {
			return null;
		}
		
		Map<String, List<Transaction>> tranMap = new HashMap<String, List<Transaction>>();
		
		for(Transaction transaction : transactions) {
			String batchId = transaction.getUfSendBatchId();
			List<Transaction> trans = tranMap.get(batchId);
			if(trans == null) {
				trans = new ArrayList<Transaction>();
			}
			trans.add(transaction);
		}
		
		List<CMBBatchPaymentDto> batchPayments = new ArrayList<CMBBatchPaymentDto> ();
		
		Set<String> batchIds = tranMap.keySet();
		int count = 0;
		for(String batchId: batchIds) {
			count ++;
			CMBBatchPaymentDto batchPayment = new CMBBatchPaymentDto();
		
			batchPayment.setCityCode(cityCode);
			batchPayment.setTrxCode(TranxCon.CMB_RF_TRAN_CODE);
			String seqNo = genSeqNo(2, count);
			batchPayment.setSeqNo(seqNo);
			
			batchPayment.setMakedDate("");//留空
			batchPayment.setOperator("");//留空
			batchPayment.setSum("");//留空
			batchPayment.setTotal("");//留空
			batchPayment.setSysCode(TranxCon.CMB_SYS_CODE);
			batchPayment.setType(TranxCon.CMB_TYPE_DISBURES);
			batchPayment.setVersion(TranxCon.CMB_SYS_VERSION);
			
			List<Transaction> trans = tranMap.get(batchId);
			List<CMBPaymentDetailDto> paymentDetails = assembleCMBPaymentDetailDto(trans, TranxCon.CMB_RF_TRAN_CODE, seqNo);
			batchPayment.setPaymentDetails(paymentDetails);
		}
		
		return batchPayments;
		
	}
	
	private List<CMBPaymentDetailDto> assembleCMBPaymentDetailDto(List<Transaction> trans, String tranCode, String fileSeqNo) {
		if(StringUtils.isEmpty(trans)) {
			return Collections.EMPTY_LIST;
		}
		
		List<CMBPaymentDetailDto> paymentDetails = new ArrayList<CMBPaymentDetailDto>();
		int count = 0;
		for(Transaction tran : trans) {
			count ++;
			CMBPaymentDetailDto paymentDetailDto = new CMBPaymentDetailDto();
			
			String crtSQN = "";//收方担保编号需要从业务系统传过来
			String yurRef = genYurRef(crtSQN, tranCode, fileSeqNo, count);
			paymentDetailDto.setYurRef(yurRef);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			String eptDate = dateFormat.format(new Date());
			paymentDetailDto.setEptDate(eptDate);
			String dbtAcc = "";//need be configured
			paymentDetailDto.setDbtAcc(dbtAcc);
			String dbtBbk="";//need be configured
			paymentDetailDto.setDbtBbk(dbtBbk);
			paymentDetailDto.setTrsAmt(tran.getAmount().toString());
			paymentDetailDto.setCcyNbr(TranxCon.C_CCYNBR);
			paymentDetailDto.setStlChn(TranxCon.C_STLCHN);
			paymentDetailDto.setNusAge(TranxCon.N_USAGE);
			paymentDetailDto.setCrtAcc(tran.getAccountNo());
			paymentDetailDto.setCrtNam(tran.getAccountName());
			paymentDetailDto.setCrtBnk(tran.getBankName());
			paymentDetailDto.setCrtPvc(tran.getBankProvince());
			paymentDetailDto.setCrtCty(tran.getBankCity());
			paymentDetailDto.setCrtSQN(crtSQN);
			
		}
		
		return paymentDetails;
	}
	
	public static CMBBatchPaymentDto assembleCMBPaymentDto (RfTransactionBatchDto rfTransactionBatchDto, Map<String, String> configMap) {
		if(rfTransactionBatchDto == null) {
			log.warn("The rfTransactionBatchDto is null");
			return null;
		}
		
		CMBBatchPaymentDto batchPayment = new CMBBatchPaymentDto();
		
	    String cityCode = rfTransactionBatchDto.getCityCode();
	    Assert.hasText(cityCode, "城市公司代码不能为空");
		batchPayment.setCityCode(cityCode);
		
		batchPayment.setTrxCode(TranxCon.CMB_RF_TRAN_CODE);
		
		String seqNo = rfTransactionBatchDto.getSeqNo();
		Assert.hasText(seqNo, "档案序号不能为空");
		batchPayment.setSeqNo(seqNo);
		
		batchPayment.setMakedDate("");//留空
		batchPayment.setOperator("");//留空
		batchPayment.setSum("");//留空
		batchPayment.setTotal("");//留空
		batchPayment.setSysCode(TranxCon.CMB_SYS_CODE);
		batchPayment.setType(TranxCon.CMB_TYPE_DISBURES);
		batchPayment.setVersion(TranxCon.CMB_SYS_VERSION);
		
		List<RfTransactionDto> trans = rfTransactionBatchDto.getRfTransactionDtos();
		
		assembleCMBPaymentDetailDto(trans, batchPayment, configMap);
		
		
		return batchPayment;
		
	}
	
	private static void assembleCMBPaymentDetailDto(List<RfTransactionDto> trans, CMBBatchPaymentDto batchPayment, Map<String, String> configMap) {
		if(StringUtils.isEmpty(trans)) {
			log.warn("CMB payment detail is empty");
			throw new IllegalArgumentException("The RfTransactionDto list is empty.");
		}
		if(log.isDebugEnabled()) {
			log.debug("Tranx size = " + trans.size());
		}

		int count = 0;
		for(RfTransactionDto tran : trans) {
			count ++;
			CMBPaymentDetailDto paymentDetailDto = new CMBPaymentDetailDto();
			
			//帐户担保编号, 收方担保编号需要从业务系统传过来
			String crtSQN = tran.getCrtSQN();
			Assert.hasText(crtSQN, "第 " + count + " 笔业务里的账户担保编号不能为空.");
			
			String yurRef = genYurRef(crtSQN, batchPayment.getTrxCode(), batchPayment.getSeqNo(), count);
			paymentDetailDto.setYurRef(yurRef);
			
			Date expectDate = tran.getExpectSettleDate();
			Assert.notNull(expectDate, "第  " + count + " 笔业务里的期望日期不能为空.");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			String eptDate = dateFormat.format(expectDate);
			paymentDetailDto.setEptDate(eptDate);

			paymentDetailDto.setEptTime("");
			String dbtAcc = configMap.get(ConfigKeyConstants.CMB_RF_PAYMENT_DBT_ACC);
			paymentDetailDto.setDbtAcc(dbtAcc);
			String dbtBbk=configMap.get(ConfigKeyConstants.CMB_RF_PAYMENT_DBT_BBK);
			paymentDetailDto.setDbtBbk(dbtBbk);
			
			BigDecimal trsAmt = tran.getAmount();
			Assert.notNull(trsAmt, "第  " + count + " 笔业务里的交易金额不能为空.");
			trsAmt = trsAmt.setScale(2, RoundingMode.UP);
			paymentDetailDto.setTrsAmt(trsAmt.toString());
			
			paymentDetailDto.setCcyNbr(TranxCon.C_CCYNBR);
			paymentDetailDto.setStlChn(TranxCon.C_STLCHN);
			paymentDetailDto.setNusAge(TranxCon.N_USAGE);
			paymentDetailDto.setBusNar("");
			
			Assert.hasText(tran.getAccountNo(), "第  " + count + " 笔业务里的收方账号不能为空.");
			paymentDetailDto.setCrtAcc(tran.getAccountNo());
			
			Assert.hasText(tran.getAccountName(), "第  " + count + " 笔业务里的收方账户名不能为空.");
			paymentDetailDto.setCrtNam(tran.getAccountName());
			
			Assert.hasText(tran.getBankName(), "第  " + count + " 笔业务里的收方开户行不能为空.");
			paymentDetailDto.setCrtBnk(tran.getBankName());
			
			Assert.hasText(tran.getBankProvince(), "第  " + count + " 笔业务里的收方省份不能为空.");
			paymentDetailDto.setCrtPvc(tran.getBankProvince());
			
			Assert.hasText(tran.getBankCity(), "第  " + count + " 笔业务里的收方城市不能为空.");
			paymentDetailDto.setCrtCty(tran.getBankCity());
			
			paymentDetailDto.setCrtDtr("");
			paymentDetailDto.setNtfCh1("");
			paymentDetailDto.setNtfCh2("");
			paymentDetailDto.setCrtSQN(crtSQN);
			
			batchPayment.addPaymentDetails(paymentDetailDto);
		}
	}
	
	private static String genYurRef(String crtSQN, String tranCode, String fileSeqNo, int tranSeqNo) {
		
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append(crtSQN);
		strBuffer.append(tranCode);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
		String genDate = dateFormat.format(new Date());
		strBuffer.append(genDate);
		strBuffer.append(fileSeqNo);
		//String strTranSeqNo = genSeqNo(4, tranSeqNo);
		//strBuffer.append(strTranSeqNo);

		return strBuffer.toString();
		
	}
	
	
	private static String genSeqNo(int length, int count) {
		
		int numSize = Integer.bitCount(count);
		int remainSize = length - numSize;
		
		StringBuffer strBuffer = new StringBuffer();
		for(int i=0; i<remainSize; i++) {
			strBuffer.append(TranxCon.ZERO_STR);
		}
		
		strBuffer.append(count);
		
		return strBuffer.toString();
		
	}
	

}
