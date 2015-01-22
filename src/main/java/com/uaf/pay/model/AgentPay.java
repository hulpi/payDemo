package com.uaf.pay.model;


public class AgentPay {
    private Long upAgentPayOid;

    private String agentPayCode;

    private String agentPayName;

    private String remark;

    public Long getUpAgentPayOid() {
        return upAgentPayOid;
    }

    public void setUpAgentPayOid(Long upAgentPayOid) {
        this.upAgentPayOid = upAgentPayOid;
    }

    public String getAgentPayCode() {
        return agentPayCode;
    }

    public void setAgentPayCode(String agentPayCode) {
        this.agentPayCode = agentPayCode == null ? null : agentPayCode.trim();
    }

    public String getAgentPayName() {
        return agentPayName;
    }

    public void setAgentPayName(String agentPayName) {
        this.agentPayName = agentPayName == null ? null : agentPayName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}