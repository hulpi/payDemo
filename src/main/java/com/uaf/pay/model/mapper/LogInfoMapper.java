package com.uaf.pay.model.mapper;
import java.math.BigDecimal;
import com.uaf.pay.model.LogInfo;

public interface LogInfoMapper {
    int deleteByPrimaryKey(BigDecimal upLogInfoOid);

    int insert(LogInfo record);

    int insertSelective(LogInfo record);

    LogInfo selectByPrimaryKey(BigDecimal upLogInfoOid);

    int updateByPrimaryKeySelective(LogInfo record);

    int updateByPrimaryKey(LogInfo record);
}