package com.uaf.pay.dto;

public class BatchProcessDetailDto {
	 private String reqSn;
	 private Long upBatchProcessOid;
	 private Long upTransactionOid;
	 private String sn;
	public String getReqSn() {
		return reqSn;
	}
	public void setReqSn(String reqSn) {
		this.reqSn = reqSn;
	}
	public Long getUpBatchProcessOid() {
		return upBatchProcessOid;
	}
	public void setUpBatchProcessOid(Long upBatchProcessOid) {
		this.upBatchProcessOid = upBatchProcessOid;
	}
	public Long getUpTransactionOid() {
		return upTransactionOid;
	}
	public void setUpTransactionOid(Long upTransactionOid) {
		this.upTransactionOid = upTransactionOid;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	 
	 
}
