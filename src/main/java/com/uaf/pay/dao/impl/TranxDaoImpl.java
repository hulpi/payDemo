package com.uaf.pay.dao.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import com.uaf.pay.constants.TranxCon;
import com.uaf.pay.dao.TranxDao;
import com.uaf.pay.model.BatchProcess;
import com.uaf.pay.model.BatchProcessDetail;
import com.uaf.pay.model.ConfigInfo;
import com.uaf.pay.model.Transaction;

public class TranxDaoImpl implements TranxDao {
	
	private static Logger log = Logger.getLogger(TranxDaoImpl.class);
	
	private SqlSessionTemplate sqlSessionTemplate;

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public int countAuthorizedTranx() {
		
		Integer rowCount = sqlSessionTemplate.selectOne("com.uaf.pay.model.mapper.TransactionMapper.selectAuthorizedCount");
		
		return (rowCount != null)? rowCount.intValue() : 0; 
		
	}

	@Override
	public List<Transaction> queryCollections(Integer startNum, Integer endNum) {
		Map<String, Integer> parameterMap = new HashMap<String, Integer>();
		//parameterMap.put("startNum", startNum);
		parameterMap.put("endNum", endNum);
		
		List<Transaction> transactons = sqlSessionTemplate.selectList("com.uaf.pay.model.mapper.TransactionMapper.selectAuthorizedCollection", parameterMap);
		
		if(transactons == null) {
			log.info("Collection transactons is null");
			
			return Collections.EMPTY_LIST;
		}
		
		if(log.isDebugEnabled()) {
			log.debug("Collection transactons size = " + transactons.size());
			
		}
		
		return transactons;
	}

	
	public Map<String, String> queryConfigInfo() {
		List<ConfigInfo> configInfos = sqlSessionTemplate.selectList("selectAll");
		
		if(configInfos == null) {
			log.info("The configInfo is null");
			
			return Collections.EMPTY_MAP;
		}

		if(log.isDebugEnabled()) {
			    log.debug("ConfigInfo size = " + configInfos.size());
		}
		
		Map<String, String> configMap = new HashMap<String, String>();
		for(ConfigInfo configInfo : configInfos) {
			configMap.put(configInfo.getInfoKey(), configInfo.getInfoValue());
		}
		
		return configMap;
	}
	
    public void updateTranxToSent(List<Long> oidList) {
		
    	if(!oidList.isEmpty()) {
    		Map<String,Object> params = new HashMap<String,Object>();
			params.put("oids", oidList);
			params.put("status", TranxCon.TRANSACTION_STATUS_SENT);
		    sqlSessionTemplate.update("com.uaf.pay.model.mapper.TransactionMapper.updateStatus", params);
    	}

	}

	@Override
	public void updateTranx(List<Long> sucessOidList, List<Long> failOidList) {
		
		if(sucessOidList != null && !sucessOidList.isEmpty()) {
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("oids", sucessOidList);
			params.put("status", TranxCon.TRANSACTION_STATUS_SUCESS);
			sqlSessionTemplate.update("com.uaf.pay.model.mapper.TransactionMapper.updateStatus", params);
		}
		
		if(failOidList != null && !failOidList.isEmpty()) {
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("oids", failOidList);
			params.put("status", TranxCon.TRANSACTION_STATUS_FAIL);
			sqlSessionTemplate.update("com.uaf.pay.model.mapper.TransactionMapper.updateStatus", params);
		}

	}
	
	public Long queryBatchProcessSeq() {
		Long seq = sqlSessionTemplate.selectOne("com.uaf.pay.model.mapper.BatchProcessMapper.selectSeq");
		
		return seq;
	}
	
	public Long queryBatchProcessDetailSeq() {
		Long seq = sqlSessionTemplate.selectOne("com.uaf.pay.model.mapper.BatchProcessDetailMapper.selectSeq");
		
		return seq;
	}
	
	public void insertBatchProcess(BatchProcess batchProcess) {
		if(batchProcess == null) {
			return;
		}
		
		sqlSessionTemplate.insert("com.uaf.pay.model.mapper.BatchProcessMapper.insert", batchProcess);
		
	}
	
    public void insertBatchProcessDetail(List<BatchProcessDetail> batchProcessDetails) {
    	if(batchProcessDetails == null || batchProcessDetails.isEmpty()) {
    		return;
    	}
    	
    	for(BatchProcessDetail batchDetail : batchProcessDetails) {
    	    sqlSessionTemplate.insert("com.uaf.pay.model.mapper.BatchProcessDetailMapper.insert", batchDetail);
    	}
		
	}

	@Override
	public List<Transaction> queryCMBRFPayments(String cityCode) {
		if(StringUtils.isEmpty(cityCode)) {
			return Collections.EMPTY_LIST;
		}
		
        List<Transaction> transactons = sqlSessionTemplate.selectList(
        		"com.uaf.pay.model.mapper.TransactionMapper.selectCMBRFPayment", cityCode);
		
		if(transactons == null) {
			log.info("CMB RF Payment transactons is null");
			
			return Collections.EMPTY_LIST;
		}
		
		if(log.isDebugEnabled()) {
			log.debug("CMB RF Payment transactons size = " + transactons.size());
			
		}
		
		return transactons;

	}

}
