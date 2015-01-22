package com.uaf.pay.status;

public class TransactionStatus {

	public static final String AUDITED = "1";//已审核
	public static final String VALIDATE_FAIL = "2";//数据不合法
	public static final String RESENDS = "3";//需要重新发送
	public static final String TRANSFERRED = "4";//已传输
	public static final String DELIVER_SUCCESS = "5";//传输成功
	public static final String DELIVER_FAILS = "6";//传输失败
	public static final String TRANSACTION_SUCCESSFUL  = "7";// 交易成功
	public static final String TRANSACTION_FAILS  = "8";//交易失败

}
