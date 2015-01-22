package com.uaf.pay.model;

import java.math.BigDecimal;

public class BankMapping {
    private BigDecimal upBankMappingOid;

    private String originalBankCode;

    private String destinedBankCode;

    private String purposeType;

    private String bankName;

    private String remark;

    public BigDecimal getUpBankMappingOid() {
        return upBankMappingOid;
    }

    public void setUpBankMappingOid(BigDecimal upBankMappingOid) {
        this.upBankMappingOid = upBankMappingOid;
    }

    public String getOriginalBankCode() {
        return originalBankCode;
    }

    public void setOriginalBankCode(String originalBankCode) {
        this.originalBankCode = originalBankCode == null ? null : originalBankCode.trim();
    }

    public String getDestinedBankCode() {
        return destinedBankCode;
    }

    public void setDestinedBankCode(String destinedBankCode) {
        this.destinedBankCode = destinedBankCode == null ? null : destinedBankCode.trim();
    }

    public String getPurposeType() {
        return purposeType;
    }

    public void setPurposeType(String purposeType) {
        this.purposeType = purposeType == null ? null : purposeType.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}