package com.uaf.pay.model.mapper;

import java.math.BigDecimal;
import com.uaf.pay.model.BatchProcessDetail;

public interface BatchProcessDetailMapper {
    int deleteByPrimaryKey(BigDecimal upBatchProcessDetailOid);

    int insert(BatchProcessDetail record);

    int insertSelective(BatchProcessDetail record);

    BatchProcessDetail selectByPrimaryKey(BigDecimal upBatchProcessDetailOid);

    int updateByPrimaryKeySelective(BatchProcessDetail record);

    int updateByPrimaryKey(BatchProcessDetail record);
}