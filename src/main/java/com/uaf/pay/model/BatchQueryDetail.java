package com.uaf.pay.model;

import java.math.BigDecimal;
import java.util.Date;

public class BatchQueryDetail {
    private Long upBatchQueryDetailOid;

    private Long upBatchQueryOid;

    private Long upTransactionOid;

    private String sn;

    private String trxDir;

    private String settday;

    private String finishTime;

    private String submitTime;

    private String accountNo;

    private String accountName;

    private BigDecimal amount;

    private String custUserId;

    private String remark;

    private String returnCode;

    private String errorMsg;

    private Date createDate;

    public Long getUpBatchQueryDetailOid() {
        return upBatchQueryDetailOid;
    }

    public void setUpBatchQueryDetailOid(Long upBatchQueryDetailOid) {
        this.upBatchQueryDetailOid = upBatchQueryDetailOid;
    }

    public Long getUpBatchQueryOid() {
        return upBatchQueryOid;
    }

    public void setUpBatchQueryOid(Long upBatchQueryOid) {
        this.upBatchQueryOid = upBatchQueryOid;
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
        this.sn = sn == null ? null : sn.trim();
    }

    public String getTrxDir() {
        return trxDir;
    }

    public void setTrxDir(String trxDir) {
        this.trxDir = trxDir == null ? null : trxDir.trim();
    }

    public String getSettday() {
        return settday;
    }

    public void setSettday(String settday) {
        this.settday = settday == null ? null : settday.trim();
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime == null ? null : finishTime.trim();
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime == null ? null : submitTime.trim();
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo == null ? null : accountNo.trim();
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCustUserId() {
        return custUserId;
    }

    public void setCustUserId(String custUserId) {
        this.custUserId = custUserId == null ? null : custUserId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode == null ? null : returnCode.trim();
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg == null ? null : errorMsg.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}