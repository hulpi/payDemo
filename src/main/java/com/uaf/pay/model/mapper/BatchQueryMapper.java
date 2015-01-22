package com.uaf.pay.model.mapper;

import java.math.BigDecimal;
import com.uaf.pay.model.BatchQuery;

public interface BatchQueryMapper {
    int deleteByPrimaryKey(BigDecimal upBatchQueryOid);

    int insert(BatchQuery record);

    int insertSelective(BatchQuery record);

    BatchQuery selectByPrimaryKey(BigDecimal upBatchQueryOid);

    int updateByPrimaryKeySelective(BatchQuery record);

    int updateByPrimaryKey(BatchQuery record);
}