package com.uaf.pay.model;


public class ConfigInfo {
    private Long upConfigInfoOid;

    private String infoKey;

    private String infoValue;

    private String description;

    public Long getUpConfigInfoOid() {
        return upConfigInfoOid;
    }

    public void setUpConfigInfoOid(Long upConfigInfoOid) {
        this.upConfigInfoOid = upConfigInfoOid;
    }

    public String getInfoKey() {
        return infoKey;
    }

    public void setInfoKey(String infoKey) {
        this.infoKey = infoKey == null ? null : infoKey.trim();
    }

    public String getInfoValue() {
        return infoValue;
    }

    public void setInfoValue(String infoValue) {
        this.infoValue = infoValue == null ? null : infoValue.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}