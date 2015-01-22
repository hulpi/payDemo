package com.uaf.pay.model.mapper;

import java.math.BigDecimal;
import com.uaf.pay.model.BatchQueryDetail;

public interface BatchQueryDetailMapper {
    int deleteByPrimaryKey(BigDecimal upBatchQueryDetailOid);

    int insert(BatchQueryDetail record);

    int insertSelective(BatchQueryDetail record);

    BatchQueryDetail selectByPrimaryKey(BigDecimal upBatchQueryDetailOid);

    int updateByPrimaryKeySelective(BatchQueryDetail record);

    int updateByPrimaryKey(BatchQueryDetail record);
}