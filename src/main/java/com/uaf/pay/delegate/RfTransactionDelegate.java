package com.uaf.pay.delegate;

import com.uaf.pay.service.CMBService;
import com.uaf.pay.util.SpringContextTool;

public class RfTransactionDelegate {
	
	public boolean genRfPaymentForCMB (String xmlStr)throws Exception {
		CMBService cmbService =(CMBService)SpringContextTool.getApplicationContext().getBean("cmbService");
		
		cmbService.genPaymentDoc(xmlStr);
		
		return true;
	}

}
