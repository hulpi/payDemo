package com.uaf.pay.presentation;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uaf.pay.dto.QueryTransactionDto;
import com.uaf.pay.dto.UiTransactionDTO;
import com.uaf.pay.service.TransactionService;
import com.uaf.pay.util.SpringContextTool;

@Controller
public class TransactionController {

	@RequestMapping(value = "/getAllinpayTransactions", method = RequestMethod.POST)
	public String getAllinpayTransactions(QueryTransactionDto dto, ModelMap model) {
		TransactionService transactionService = (TransactionService) SpringContextTool.getApplicationContext().getBean("transactionService");
		List<UiTransactionDTO> list = transactionService.getAllinpayTransactions(dto);
		model.addAttribute("transList", list);
		return "transactionList";
	}
	
	
	@RequestMapping(value = "/updateAllinPayInfo", method = RequestMethod.POST)
	public String updateAllinPayInfo(QueryTransactionDto dto, ModelMap model) {
		TransactionService transactionService = (TransactionService) SpringContextTool.getApplicationContext().getBean("transactionService");
		transactionService.updateAllinPayInfo(dto.getUpTransactionOid());
		List<UiTransactionDTO> list =transactionService.getAllinpayTransactions(dto);
		model.addAttribute("transList", list);
		return "transactionList";
	}
}
