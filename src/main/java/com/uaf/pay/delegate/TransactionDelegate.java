package com.uaf.pay.delegate;


import com.uaf.pay.service.TransactionService;
import com.uaf.pay.util.SpringContextTool;

public class TransactionDelegate {
	
	
	/*http://10.168.96.37:8080/uafpay/services/TransactionDelegate?wsdl
	 * http://localhost:8080/WASTest/sampleTransactionDelegateProxy/TestClient.jsp*/
	public boolean conveyPaymentInfo (String xmlStr)throws Exception {
		TransactionService transactionService =(TransactionService)SpringContextTool.getApplicationContext().getBean("transactionService");
		return transactionService.addTransaction(xmlStr);
	}
	
	public String getTransaction(String xmlStr){
		TransactionService transactionService =(TransactionService)SpringContextTool.getApplicationContext().getBean("transactionService");
		return transactionService.getTransaction(xmlStr);
	}
}
