package com.uaf.pay.model.mapper;

import java.math.BigDecimal;
import com.uaf.pay.model.SysRegister;

public interface SysRegisterMapper {
    int deleteByPrimaryKey(BigDecimal upSysRegisterOid);

    int insert(SysRegister record);

    int insertSelective(SysRegister record);

    SysRegister selectByPrimaryKey(BigDecimal upSysRegisterOid);

    int updateByPrimaryKeySelective(SysRegister record);

    int updateByPrimaryKey(SysRegister record);
}