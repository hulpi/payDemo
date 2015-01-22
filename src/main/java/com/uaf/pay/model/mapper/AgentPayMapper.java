package com.uaf.pay.model.mapper;

import java.math.BigDecimal;
import com.uaf.pay.model.AgentPay;

public interface AgentPayMapper {
    int deleteByPrimaryKey(BigDecimal upAgentPayOid);

    int insert(AgentPay record);

    int insertSelective(AgentPay record);

    AgentPay selectByPrimaryKey(BigDecimal upAgentPayOid);

    int updateByPrimaryKeySelective(AgentPay record);

    int updateByPrimaryKey(AgentPay record);
}