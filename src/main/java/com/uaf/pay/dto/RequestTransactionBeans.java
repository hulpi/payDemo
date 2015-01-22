package com.uaf.pay.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "appLedgSeqIdList")

public class RequestTransactionBeans {
	private List<AppLedgSeqIdDto> appLedgSeqIdList;

	public List<AppLedgSeqIdDto> getAppLedgSeqIdList() {
		return appLedgSeqIdList;
	}

	public void setAppLedgSeqIdList(List<AppLedgSeqIdDto> appLedgSeqIdList) {
		this.appLedgSeqIdList = appLedgSeqIdList;
	}
	
}
