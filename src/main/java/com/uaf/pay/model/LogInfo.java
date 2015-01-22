package com.uaf.pay.model;

import java.math.BigDecimal;
import java.util.Date;

public class LogInfo {
    private BigDecimal upLogInfoOid;

    private String type;

    private String content;

    private String creator;

    private Date createDate;

    public BigDecimal getUpLogInfoOid() {
        return upLogInfoOid;
    }

    public void setUpLogInfoOid(BigDecimal upLogInfoOid) {
        this.upLogInfoOid = upLogInfoOid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}