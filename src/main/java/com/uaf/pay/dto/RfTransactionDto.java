package com.uaf.pay.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "rfTransaction")
@XmlType(propOrder = {
		"crtSQN" 
		})
public class RfTransactionDto extends TransactionDto {
	
	private String crtSQN;

	public String getCrtSQN() {
		return crtSQN;
	}

	public void setCrtSQN(String crtSQN) {
		this.crtSQN = crtSQN;
	}
	

}
