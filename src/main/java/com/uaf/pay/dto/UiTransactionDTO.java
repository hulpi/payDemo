package com.uaf.pay.dto;

import java.math.BigDecimal;
import java.util.Date;

public class UiTransactionDTO {

	private Long upTransactionOid;
	
	private String upAgentPayCode;

    private String ufAppCode;

    private String ufCityCode;

    private String payType;

    private String accountNo;

    private String accountName;

    private String bankCode;

    private String bankName;

    private String bankProvince;

    private String bankCity;

    private String settleType;

    private BigDecimal amount;

    private String currency;

    private Date expectSettleDate;

    private Date actualSettleDate;

    private String status;

    private String confirmUser;

    private Date confirmDate;

    private int versionNo;

    private String remark;

    private Date createDate;

	public Long getUpTransactionOid() {
		return upTransactionOid;
	}

	public void setUpTransactionOid(Long upTransactionOid) {
		this.upTransactionOid = upTransactionOid;
	}

	public String getUpAgentPayCode() {
		return upAgentPayCode;
	}

	public void setUpAgentPayCode(String upAgentPayCode) {
		this.upAgentPayCode = upAgentPayCode;
	}

	public String getUfAppCode() {
		return ufAppCode;
	}

	public void setUfAppCode(String ufAppCode) {
		this.ufAppCode = ufAppCode;
	}

	public String getUfCityCode() {
		return ufCityCode;
	}

	public void setUfCityCode(String ufCityCode) {
		this.ufCityCode = ufCityCode;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankProvince() {
		return bankProvince;
	}

	public void setBankProvince(String bankProvince) {
		this.bankProvince = bankProvince;
	}

	public String getBankCity() {
		return bankCity;
	}

	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}

	public String getSettleType() {
		return settleType;
	}

	public void setSettleType(String settleType) {
		this.settleType = settleType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getExpectSettleDate() {
		return expectSettleDate;
	}

	public void setExpectSettleDate(Date expectSettleDate) {
		this.expectSettleDate = expectSettleDate;
	}

	public Date getActualSettleDate() {
		return actualSettleDate;
	}

	public void setActualSettleDate(Date actualSettleDate) {
		this.actualSettleDate = actualSettleDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getConfirmUser() {
		return confirmUser;
	}

	public void setConfirmUser(String confirmUser) {
		this.confirmUser = confirmUser;
	}

	public Date getConfirmDate() {
		return confirmDate;
	}

	public void setConfirmDate(Date confirmDate) {
		this.confirmDate = confirmDate;
	}

	public int getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(int versionNo) {
		this.versionNo = versionNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
    
    
}
