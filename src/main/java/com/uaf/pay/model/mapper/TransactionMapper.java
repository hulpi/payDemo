package com.uaf.pay.model.mapper;

import java.math.BigDecimal;
import java.util.List;

import com.uaf.pay.dto.UiTransactionDTO;
import com.uaf.pay.model.Transaction;

public interface TransactionMapper {
    int deleteByPrimaryKey(BigDecimal upTransactionOid);

    int insert(Transaction record);
    int insertSelective(Transaction record);

    Transaction selectByPrimaryKey(BigDecimal upTransactionOid);

    int updateByPrimaryKeySelective(Transaction record);

    int updateByPrimaryKey(Transaction record);
    
    List<Transaction> queryTransactions(UiTransactionDTO dto);
}