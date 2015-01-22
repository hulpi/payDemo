package com.uaf.pay.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "appLedgSeqId")
@XmlType(propOrder = { 
		"ufAppLedgSeqId",
		})
public class AppLedgSeqIdDto {
	 private String ufAppLedgSeqId;

	public String getUfAppLedgSeqId() {
		return ufAppLedgSeqId;
	}

	public void setUfAppLedgSeqId(String ufAppLedgSeqId) {
		this.ufAppLedgSeqId = ufAppLedgSeqId;
	}
	 
}
