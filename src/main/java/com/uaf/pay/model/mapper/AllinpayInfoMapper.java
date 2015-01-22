package com.uaf.pay.model.mapper;

import java.math.BigDecimal;
import com.uaf.pay.model.AllinpayInfo;

public interface AllinpayInfoMapper {
    int deleteByPrimaryKey(BigDecimal upAllinpayInfoOid);

    int insert(AllinpayInfo record);

    int insertSelective(AllinpayInfo record);

    AllinpayInfo selectByPrimaryKey(BigDecimal upAllinpayInfoOid);

    int updateByPrimaryKeySelective(AllinpayInfo record);

    int updateByPrimaryKey(AllinpayInfo record);
}