package com.uaf.pay.model.mapper;

import java.math.BigDecimal;

import com.uaf.pay.model.ConfigInfo;

public interface ConfigInfoMapper {
    int deleteByPrimaryKey(BigDecimal upConfigInfoOid);

    int insert(ConfigInfo record);
    int insertSeq(ConfigInfo record);

    int insertSelective(ConfigInfo record);

    ConfigInfo selectByPrimaryKey(BigDecimal upConfigInfoOid);

    int updateByPrimaryKeySelective(ConfigInfo record);

    int updateByPrimaryKey(ConfigInfo record);
}