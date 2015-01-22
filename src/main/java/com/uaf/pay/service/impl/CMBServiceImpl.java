package com.uaf.pay.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;

import com.uaf.pay.constants.ConfigKeyConstants;
import com.uaf.pay.constants.TranxCon;
import com.uaf.pay.dao.CommonDao;
import com.uaf.pay.dao.TranxDao;
import com.uaf.pay.dto.CMBBatchPaymentDto;
import com.uaf.pay.dto.RfTransactionBatchDto;
import com.uaf.pay.model.Transaction;
import com.uaf.pay.service.CMBService;
import com.uaf.pay.support.TranxAssembler;
import com.uaf.pay.util.FileUtil;
import com.uaf.pay.util.SMBremoteFileUtil;
import com.uaf.pay.util.XMLUtil;

public class CMBServiceImpl implements CMBService {
private static Logger log = Logger.getLogger(AIPTranxServiceImpl.class);
	
	private TranxDao tranxDao;
	
	private CommonDao commonDao;
	
	private Map<String, String> configMap;
	
	@Override
	public void genPaymentDoc(String xmlStr) {
		if(log.isDebugEnabled()) {
			log.debug("The xmlStr: " + xmlStr);
		}
		if(StringUtils.isEmpty(xmlStr)) {
			return;
		}
		
		RfTransactionBatchDto rfTranBatchDto = (RfTransactionBatchDto) XMLUtil.convertXmlStrToObject(RfTransactionBatchDto.class, xmlStr);
		Assert.notNull(rfTranBatchDto, "The input message cannot be converted to RfTransactionBatchDto");
		
		configMap = commonDao.getAllConfigInfo();
		
		CMBBatchPaymentDto cmbBatchPayment = TranxAssembler.assembleCMBPaymentDto(rfTranBatchDto, configMap);
		
		String filePath = configMap.get(ConfigKeyConstants.CMB_RF_PAYMENT_FILE_PATH);
		if(log.isDebugEnabled()) {
			log.debug("Configured file path for CMB payment = " + filePath);
		}
		
		if(cmbBatchPayment != null && StringUtils.isNotEmpty(filePath)) {
			String systemPathSeparator = System.getProperty(TranxCon.FILE_SEPARATOR);
			String fileSeparator =  systemPathSeparator!= null? systemPathSeparator : TranxCon.PATH_SEPARATOR;
			SimpleDateFormat dateFormat = new SimpleDateFormat(TranxCon.FILE_PATH_DATE_PATTERN);
			String strDate = dateFormat.format(new Date());
			StringBuffer fileNameBuffer = new StringBuffer();
			fileNameBuffer.append(filePath).append(fileSeparator).append(strDate);
		    FileUtil.creatIfNotExsit(fileNameBuffer.toString());
		    
		    String fileName = cmbBatchPayment.getFileName();
		    fileNameBuffer.append(fileSeparator).append(fileName);
		    
			if(log.isDebugEnabled()) {
				log.debug("CMB payment file full name = " + fileNameBuffer.toString());
			}
			
			boolean isExistFile = FileUtil.isExsit(fileNameBuffer.toString());
			if(isExistFile) {
				log.warn("Duplicated file name: " + fileName);
				throw new IllegalArgumentException("城市 " +cmbBatchPayment.getCityCode() + " 的档案序号: " + cmbBatchPayment.getSeqNo() + "已存在");
			}
			
			String fileContent = cmbBatchPayment.getFileContent();
			if(log.isDebugEnabled()) {
				log.debug("CMB payment file content = " + fileContent);
			}
			
		    FileUtil.saveToFile(fileContent, fileNameBuffer.toString(), TranxCon.ENCODING_UTF_8);
		    
		    //备份RF退款文档到财务windows服务器上
		    String remoteUrl = configMap.get(ConfigKeyConstants.CMB_RF_PAYMENT_FILE_FINANCE_SMB_PATH);
		    String cityCode = rfTranBatchDto.getCityCode();
		    
		    SimpleDateFormat dateFormatRf = new SimpleDateFormat("yyyy-MM/dd");
			String rfDate = dateFormatRf.format(new Date());
		    
		    remoteUrl = remoteUrl + TranxCon.PATH_SEPARATOR 
		    		+ cityCode+ TranxCon.PATH_SEPARATOR 
		    		+ rfDate + TranxCon.PATH_SEPARATOR;
		    SMBremoteFileUtil.smbWriteContent(remoteUrl, fileName, fileContent, TranxCon.ENCODING_UTF_8);
		}
		
		
		
	}


	public void genPaymentDoc() {
        Map<String, String> configMap = commonDao.getAllConfigInfo();
		
		String filePath = configMap.get(ConfigKeyConstants.CMB_RF_PAYMENT_FILE_PATH);
		Assert.notNull(filePath, "The CMB RF payment file path  must not null, it should be configured to DB first");
		
		String szCityCode = "01";
		//Query batch data of RF payment
		List<Transaction> transactions = tranxDao.queryCMBRFPayments(szCityCode);

		if(log.isDebugEnabled()) {
			log.debug(" Final payment size = " + transactions.size());
		}
		
		if(transactions == null || transactions.isEmpty()) {
			log.info("No payment need be sent");
			return;
		}
		
	}

	public void setTranxDao(TranxDao tranxDao) {
		this.tranxDao = tranxDao;
	}

	public void setCommonDao(CommonDao commonDao) {
		this.commonDao = commonDao;
	}
	
	

}
