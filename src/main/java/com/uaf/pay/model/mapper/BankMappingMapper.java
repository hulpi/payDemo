package com.uaf.pay.model.mapper;

import com.uaf.pay.model.BankMapping;
import java.math.BigDecimal;

public interface BankMappingMapper {
    int deleteByPrimaryKey(BigDecimal upBankMappingOid);

    int insert(BankMapping record);

    int insertSelective(BankMapping record);

    BankMapping selectByPrimaryKey(BigDecimal upBankMappingOid);

    int updateByPrimaryKeySelective(BankMapping record);

    int updateByPrimaryKey(BankMapping record);
}