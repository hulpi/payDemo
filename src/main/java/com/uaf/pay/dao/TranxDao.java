package com.uaf.pay.dao;


import java.util.List;
import java.util.Map;

import com.uaf.pay.model.BatchProcess;
import com.uaf.pay.model.BatchProcessDetail;
import com.uaf.pay.model.Transaction;


public interface TranxDao {
	
	public Map<String, String> queryConfigInfo();
	
	public List<Transaction> queryCollections(Integer startNum, Integer endNum);
	
	public int countAuthorizedTranx();
	
	public void updateTranxToSent(List<Long> oidList);
	
	public void updateTranx(List<Long> sucessOidList, List<Long> failOidList);
	
	public Long queryBatchProcessSeq();
	
	public Long queryBatchProcessDetailSeq();
	
	public void insertBatchProcess(BatchProcess batchProcess);
	
    public void insertBatchProcessDetail(List<BatchProcessDetail> batchProcessDetails);
    
    public List<Transaction> queryCMBRFPayments(String cityCode);

}
