package com.uaf.pay.constants;

public class ConfigKeyConstants {

//通联支付报文的交易代码	
public static final String AIPG_XMLMSG_TRANS_INFO_COLLECTION_TRX_CODE ="allinpay.xmlmessage.transaction.info.collection.trx_code";
//通联查询报文的交易代码
public static final String AIPG_XMLMSG_TRANS_INFO_QUERY_TRX_CODE = "allinpay.xmlmessage.transaction.info.query_trx_code";

//通联支付报文的版本号
public static final String AIPG_XMLMSG_TRANS_INFO_VERSION ="allinpay.xmlmessage.transaction.info.version";

//通联支付报文的处理优先级:[0-9]
public static final String AIPG_XMLMSG_TRANS_INFO_LEVEL ="allinpay.xmlmessage.transaction.info.level";

//通联支付报文的用户名
public static final String AIPG_XMLMSG_TRANS_INFO_USER_NAME ="allinpay.xmlmessage.transaction.info.user_name";

 
//通联支付报文的密码
public static final String AIPG_XMLMSG_TRANS_INFO_USER_PASS ="allinpay.xmlmessage.transaction.info.user_pass";


//通联支付报文的代付业务代码
public static final String AIPG_XMLMSG_TRANS_BODY_BUSSINESS_CODE ="allinpay.xmlmessage.transaction.body.bussiness_code";


//通联支付报文的商户号
public static final String AIPG_XMLMSG_TRANS_BODY_MERCHANT_ID ="allinpay.xmlmessage.transaction.body.merchant_id";

     
//通联支付报文的默认账号类型：[00-银行卡 01-存折 02-信用卡]
public static final String AIPG_XMLMSG_TRANS_BODY_ACCOUNT_TYPE ="allinpay.xmlmessage.transaction.body.account_type";

//通联支付报文的批次大小
public static final String AIPG_XMLMSG_TRANS_COMMON_BATCH_SIZE ="allinpay.xmlmessage.transaction.common.batch_size";

public static final String AIPG_XMLMSG_TRANS_COMMON_BATCH_PFXPATH = "allinpay.xmlmessage.transaction.common.pfxPath";

public static final String AIPG_XMLMSG_TRANS_COMMON_BATCH_TLTCERPATH = "allinpay.xmlmessage.transaction.common.tltcerPath";

public static final String AIPG_XMLMSG_TRANS_COMMON_BATCH_PFXPASSWORD = "allinpay.xmlmessage.transaction.common.pfxPassword";

public static final String AIPG_XMLMSG_TRANS_COMMON_BATCH_FILE_PATH = "allinpay.xmlmessage.transaction.common.batch.file.path";

public static final String AIPG_XMLMSG_TRANS_COMMON_BATCH_TRAN_URL = "allinpay.xmlmessage.transaction.common.tran.url";

public static final String AIPG_XMLMSG_TRANS_QUERY_BATCH_FILE_PATH = "allinpay.xmlmessage.transaction.common.query.file.path";

public static final String AIPG_XMLMSG_TRANS_INFO_PAYMENT_TRX_CODE ="allinpay.xmlmessage.transaction.info.payment.trx_code";

//档案文件路径
public static final String CMB_RF_PAYMENT_FILE_PATH = "cmb.rf.payment.file.path";
//财务服务器 档案文件路径
public static final String CMB_RF_PAYMENT_FILE_FINANCE_SMB_PATH = "cmb.rf.payment.file.finance_smb_path";

//付方帐号
public static final String CMB_RF_PAYMENT_DBT_ACC = "cmb.rf.payment.dbt.acc";

//付方开户地区
public static final String CMB_RF_PAYMENT_DBT_BBK = "cmb.rf.payment.dbt.bbk";



}
