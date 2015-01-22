package com.uaf.pay.dto;

import java.util.List;

public class AIPTranxReqDto {
	//Info
	private String trxCode;
	private String version;
	private String dataType;
	private String level;
	private String userName;
	private String userPass;
	private String reqSN;
	private String signedMsg;
	
	//trans summary
	private String businessCode;
	private String merchantId;
	private String setDate;
	private String submitTime;
	private String totalItem;
	private String totalSum;
	
	//Details
	List<AIPTranxReqDetailDto> aipTranxReqDetailDtos;

	public String getTrxCode() {
		return trxCode;
	}

	public void setTrxCode(String trxCode) {
		this.trxCode = trxCode;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getReqSN() {
		return reqSN;
	}

	public void setReqSN(String reqSN) {
		this.reqSN = reqSN;
	}

	public String getSignedMsg() {
		return signedMsg;
	}

	public void setSignedMsg(String signedMsg) {
		this.signedMsg = signedMsg;
	}

	public String getBusinessCode() {
		return businessCode;
	}

	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getSetDate() {
		return setDate;
	}

	public void setSetDate(String setDate) {
		this.setDate = setDate;
	}

	public String getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}

	public String getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(String totalItem) {
		this.totalItem = totalItem;
	}

	public String getTotalSum() {
		return totalSum;
	}

	public void setTotalSum(String totalSum) {
		this.totalSum = totalSum;
	}

	public List<AIPTranxReqDetailDto> getAipTranxReqDetailDtos() {
		return aipTranxReqDetailDtos;
	}

	public void setAipTranxReqDetailDtos(
			List<AIPTranxReqDetailDto> aipTranxReqDetailDtos) {
		this.aipTranxReqDetailDtos = aipTranxReqDetailDtos;
	}

}
