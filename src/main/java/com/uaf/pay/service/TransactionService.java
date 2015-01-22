package com.uaf.pay.service;

import java.util.List;
import java.util.Map;

import com.uaf.pay.dto.QueryTransactionDto;
import com.uaf.pay.dto.UiTransactionDTO;

public interface TransactionService {
	
	boolean addTransaction(String xmlStr)throws Exception ;
	String getTransaction(String xmlStr);
	
	//get allinpay 
	List<UiTransactionDTO> getAllinpayTransactions(QueryTransactionDto dto);
	
	void updateAllinPayInfo(List<Long> transactionOids);
}
