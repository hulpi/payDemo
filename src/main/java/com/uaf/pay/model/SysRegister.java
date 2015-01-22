package com.uaf.pay.model;

import java.math.BigDecimal;

public class SysRegister {
    private BigDecimal upSysRegisterOid;

    private String sysRegisterCode;

    private String sysName;

    private String status;

    private String remark;

    public BigDecimal getUpSysRegisterOid() {
        return upSysRegisterOid;
    }

    public void setUpSysRegisterOid(BigDecimal upSysRegisterOid) {
        this.upSysRegisterOid = upSysRegisterOid;
    }

    public String getSysRegisterCode() {
        return sysRegisterCode;
    }

    public void setSysRegisterCode(String sysRegisterCode) {
        this.sysRegisterCode = sysRegisterCode == null ? null : sysRegisterCode.trim();
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName == null ? null : sysName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}