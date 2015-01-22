package com.uaf.pay.exception;

public class AIPTranxServiceException extends Exception {

	private static final long serialVersionUID = 1L;


	public AIPTranxServiceException() {
	    super();
    }

    public AIPTranxServiceException(String message) {
    	super(message);
    }

    
    public AIPTranxServiceException(String message, Throwable cause) {
        super(message, cause);
    }

   
    public AIPTranxServiceException(Throwable cause) {
        super(cause);
    }
}
