package com.uaf.pay.model;

import java.util.Date;

public class BatchProcessDetail {
    private Long upBatchProcessDetailOid;

    private Long upBatchProcessOid;

    private Long upTransactionOid;

    private String sn;

    private String returnCode;

    private String errorMsg;

    private Date createDate;

    public Long getUpBatchProcessDetailOid() {
        return upBatchProcessDetailOid;
    }

    public void setUpBatchProcessDetailOid(Long upBatchProcessDetailOid) {
        this.upBatchProcessDetailOid = upBatchProcessDetailOid;
    }

    public Long getUpBatchProcessOid() {
        return upBatchProcessOid;
    }

    public void setUpBatchProcessOid(Long upBatchProcessOid) {
        this.upBatchProcessOid = upBatchProcessOid;
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