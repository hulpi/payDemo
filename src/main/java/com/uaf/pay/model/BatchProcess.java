package com.uaf.pay.model;

import java.math.BigDecimal;
import java.util.Date;

public class BatchProcess {
    private Long upBatchProcessOid;

    private String filePath;

    private Long totalItem;

    private BigDecimal totalSum;

    private String reqSn;

    private String returnCode;

    private String status;

    private String errorMsg;

    private Date createDate;

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

    public Long getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(Long totalItem) {
        this.totalItem = totalItem;
    }

    public BigDecimal getTotalSum() {
		return totalSum;
	}

	public void setTotalSum(BigDecimal totalSum) {
		this.totalSum = totalSum;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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