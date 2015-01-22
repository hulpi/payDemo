package com.uaf.pay.scheduler;

import org.apache.log4j.Logger;

import com.uaf.pay.service.AIPTranxService;

public class AIPCollectionJob {
	
	private static Logger log = Logger.getLogger(AIPCollectionJob.class.getName());

	private AIPTranxService aipTranxService;
	
	public void execute() {
		if(log.isDebugEnabled()) {
		    log.debug("#### start execute AIPCollectionJob... ");
		}
        
        //Call TranxService to collect money
		try {
			
			aipTranxService.doCollection();
			
		} catch (Exception e) {
			log.warn(e.getMessage());
			log.warn("Error for: " + e.getMessage());
			if(log.isDebugEnabled()) {
				StackTraceElement[] stackElement = e.getStackTrace();
				if(stackElement != null) {
					for(StackTraceElement element : stackElement) {
						log.debug("Error at: " + element.getClassName() + ": " + element.getLineNumber());
					}
				}
				
			}
			
		}
        
        if(log.isDebugEnabled()) {
		    log.debug("#### End execute AIPCollectionJob... ");
		}
	}

	public void setAipTranxService(AIPTranxService aipTranxService) {
		this.aipTranxService = aipTranxService;
	}
	
}
