package com.uaf.pay.model;

import java.util.Date;

public class AllinpayInfo {
    private Long upAllinpayInfoOid;

    private Long upTransactionOid;

    private String eUserCode;

    private String protocol;

    private String protocolUser;

    private String idType;

    private String idNumber;

    private String tel;

    private String custUserId;

    private String settacct;

    private String remark;

    private String settgroupFlag;

    private String summary;

    private String unionBank;

    private Date createDate;

    public Long getUpAllinpayInfoOid() {
        return upAllinpayInfoOid;
    }

    public void setUpAllinpayInfoOid(Long upAllinpayInfoOid) {
        this.upAllinpayInfoOid = upAllinpayInfoOid;
    }

    public Long getUpTransactionOid() {
        return upTransactionOid;
    }

    public void setUpTransactionOid(Long upTransactionOid) {
        this.upTransactionOid = upTransactionOid;
    }

    public String geteUserCode() {
        return eUserCode;
    }

    public void seteUserCode(String eUserCode) {
        this.eUserCode = eUserCode == null ? null : eUserCode.trim();
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol == null ? null : protocol.trim();
    }

    public String getProtocolUser() {
        return protocolUser;
    }

    public void setProtocolUser(String protocolUser) {
        this.protocolUser = protocolUser == null ? null : protocolUser.trim();
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType == null ? null : idType.trim();
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getCustUserId() {
        return custUserId;
    }

    public void setCustUserId(String custUserId) {
        this.custUserId = custUserId == null ? null : custUserId.trim();
    }

    public String getSettacct() {
        return settacct;
    }

    public void setSettacct(String settacct) {
        this.settacct = settacct == null ? null : settacct.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getSettgroupFlag() {
        return settgroupFlag;
    }

    public void setSettgroupFlag(String settgroupFlag) {
        this.settgroupFlag = settgroupFlag == null ? null : settgroupFlag.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getUnionBank() {
        return unionBank;
    }

    public void setUnionBank(String unionBank) {
        this.unionBank = unionBank == null ? null : unionBank.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}