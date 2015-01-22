package com.uaf.pay.dto;

import java.util.List;

public class QueryTransactionDto {
	private List<Long> upTransactionOid;
	private String status;

	public List<Long> getUpTransactionOid() {
		return upTransactionOid;
	}

	public void setUpTransactionOid(List<Long> upTransactionOid) {
		this.upTransactionOid = upTransactionOid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
