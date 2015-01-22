package com.uaf.pay.service;

public interface AIPTranxService {
	
	//public void doPayment() throws Exception;
	
	public void doCollection() throws Exception;
	
	public void queryTrade() throws Exception;
	
	public void queryTrade(String sn)throws Exception;

}
