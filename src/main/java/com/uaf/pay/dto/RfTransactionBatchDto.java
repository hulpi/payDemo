package com.uaf.pay.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "rfTransBatch")
public class RfTransactionBatchDto {
	
	private String cityCode;
	private String trxCode;
	private String seqNo;
	
	private List <RfTransactionDto> rfTransactionDtos;

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getTrxCode() {
		return trxCode;
	}

	public void setTrxCode(String trxCode) {
		this.trxCode = trxCode;
	}

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	public List<RfTransactionDto> getRfTransactionDtos() {
		return rfTransactionDtos;
	}

	public void setRfTransactionDtos(List<RfTransactionDto> rfTransactionDtos) {
		this.rfTransactionDtos = rfTransactionDtos;
	}

}
