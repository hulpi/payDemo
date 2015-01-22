package com.uaf.pay.model.mapper;

import java.math.BigDecimal;
import com.uaf.pay.model.BatchProcess;

public interface BatchProcessMapper {
    int deleteByPrimaryKey(BigDecimal upBatchProcessOid);

    int insert(BatchProcess record);

    int insertSelective(BatchProcess record);

    BatchProcess selectByPrimaryKey(BigDecimal upBatchProcessOid);

    int updateByPrimaryKeySelective(BatchProcess record);

    int updateByPrimaryKey(BatchProcess record);
}