package com.uaf.pay.constants;

public class TranxCon {
	
	private TranxCon(){}

	
	boolean isfront=false;//是否发送至前置机（由前置机进行签名）
	public static String TRANSACTION_STATUS_SENT = "4";
	public static String TRANSACTION_STATUS_SUCESS = "5";
	public static String TRANSACTION_STATUS_FAIL = "6";
	public static String RET_CODE_SUCESS = "0000";
	public static String[] RET_CODE_MIDDLE = new String []{"2000", "2001", "2003", "2005", "2007", "2008"};
	public static String BATCH_STATUS_SENT = "1";
	public static String BATCH_STATUS_SUCESS = "2";
	public static String BATCH_STATUS_FAIL = "3";
	public static String BATCH_STATUS_QUERY_SUCESS = "4";

	public static String XML_DATA_TYPE = "2";
	public static String LEVEL_FIVE = "5";
	public static String SUBMIT_TIME_PATTERN = "yyyyMMddHHmmss";
	public static String FILE_PATH_DATE_PATTERN = "yyyyMMdd";
	public static String ACCOUNT_PROP_PRIVATE = "0";
	public static String ACCOUNT_PROP_COMPANY = "1";
	public static String ACCOUNT_PROP_CN = "CN";
	public static String ACCOUNT_PROP_CO = "CO";
	public static String XML_FILE_NAME = ".xml";
	public static String ENCODING_UTF_8 = "UTF-8";
	public static String PATH_SEPARATOR = "/";
	public static String FILE_SEPARATOR = "file.separator";
	public static String AIP_TRANX_REQ_SN_PREFIX = "TRX";
	public static String AIP_TRX_CODE = "100001";
	public static String CONFIG_PREFIX = "/config/";
	
	public static String AIP_TRANX_QUERY_REQ_SN_PREFIX = "QTRX";
	
	public static String HYPHEN = "-";
	public static String NUMBER_SIGN = "#";
	public static String EQUALS_SIGN = "=";
	public static String NEW_LINE = "\r\n";
	public static String CMB_TYPE_DISBURES = "DISBURES";
	public static String C_CCYNBR = "人民币";
	public static String C_STLCHN = "快速";
	public static String N_USAGE = "溢缴付还";
	public static String ZERO_STR = "0";
	public static String CMB_RF_FILE_NAME = ".pam";
	public static String CMB_SYS_CODE = "5464";
	public static String CMB_SYS_VERSION = "2.0";
	public static String CMB_RF_TRAN_CODE = "RF";
	public static String CMB_UAF_CODE = "100203000071601";
	public static String SEMICOLON = ";";
	public static String[] DETAIL_RET_CODE_SUCESS = {"0000","4000"};
	
}
