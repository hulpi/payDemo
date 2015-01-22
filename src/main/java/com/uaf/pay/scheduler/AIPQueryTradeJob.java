package com.uaf.pay.scheduler;

import org.apache.log4j.Logger;

import com.uaf.pay.service.AIPTranxService;

public class AIPQueryTradeJob {
	
	private static Logger log = Logger.getLogger(AIPQueryTradeJob.class.getName());
	
	private AIPTranxService aipTranxService;

	public void execute() throws Exception {
		
		log.debug("#### Start exceute query trade from AIP");
		aipTranxService.queryTrade();
		log.debug("#### End exceute query trade from AIP");
	}

	public void setAipTranxService(AIPTranxService aipTranxService) {
		this.aipTranxService = aipTranxService;
	}

}
