package com.uaf.pay.model;

import java.util.Date;

public class BatchQuery {
    private Long upBatchQueryOid;

    private Long upBatchProcessOid;

    private String filePath;

    private String reqSn;

    private String returnCode;

    private String errorMsg;

    private Date createDate;

    public Long getUpBatchQueryOid() {
        return upBatchQueryOid;
    }

    public void setUpBatchQueryOid(Long upBatchQueryOid) {
        this.upBatchQueryOid = upBatchQueryOid;
    }

    public Long getUpBatchProcessOid() {
        return upBatchProcessOid;
    }

    public void setUpBatchProcessOid(Long upBatchProcessOid) {
        this.upBatchProcessOid = upBatchProcessOid;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public String getReqSn() {
        return reqSn;
    }

    public void setReqSn(String reqSn) {
        this.reqSn = reqSn == null ? null : reqSn.trim();
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