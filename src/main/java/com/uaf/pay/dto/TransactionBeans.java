package com.uaf.pay.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "transList")

public class TransactionBeans {
	String systemId;
	
	String batchNo;
	
	List<TransactionDto> transList;

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public List<TransactionDto> getTransList() {
		return transList;
	}

	public void setTransList(List<TransactionDto> transList) {
		this.transList = transList;
	}
}
