

insert into up_config_info
  (up_config_info_oid, info_key, info_value, Description)
  select up_config_info_SEQ.nextval as up_config_info_oid,
         info_key,
         info_value,
         Description
    from (select 
    'allinpay.xmlmessage.transaction.info.collection.trx_code' as info_key, 
    '100001' as info_value, 
    '通联批量代收报文的交易代码' as Description
            from dual) d
   where not exists
   (select 1 from up_config_info t where t.info_key = d.info_key);

insert into up_config_info
  (up_config_info_oid, info_key, info_value, Description)
  select up_config_info_SEQ.nextval as up_config_info_oid,
         info_key,
         info_value,
         Description
    from (select 
    'allinpay.xmlmessage.transaction.info.payment.trx_code' as info_key, 
    '100002' as info_value, 
    '通联批量代付报文的交易代码' as Description
            from dual) d
   where not exists
   (select 1 from up_config_info t where t.info_key = d.info_key);  
  
insert into up_config_info
  (up_config_info_oid, info_key, info_value, Description)
  select up_config_info_SEQ.nextval as up_config_info_oid,
         info_key,
         info_value,
         Description
    from (select 
    'allinpay.xmlmessage.transaction.info.version' as info_key, 
    '03' as info_value, 
    '通联支付报文的版本号' as Description
            from dual) d
   where not exists
   (select 1 from up_config_info t where t.info_key = d.info_key);
   

 
insert into up_config_info
  (up_config_info_oid, info_key, info_value, Description)
  select up_config_info_SEQ.nextval as up_config_info_oid,
         info_key,
         info_value,
         Description
    from (select 
    'allinpay.xmlmessage.transaction.info.level' as info_key, 
    '5' as info_value, 
    '通联支付报文的处理优先级:[0-9]' as Description
            from dual) d
   where not exists
   (select 1 from up_config_info t where t.info_key = d.info_key);
   
 
insert into up_config_info
  (up_config_info_oid, info_key, info_value, Description)
  select up_config_info_SEQ.nextval as up_config_info_oid,
         info_key,
         info_value,
         Description
    from (select 
    'allinpay.xmlmessage.transaction.info.user_name' as info_key, 
    '20060400000044502' as info_value, 
    '通联支付报文的用户名' as Description
            from dual) d
   where not exists
   (select 1 from up_config_info t where t.info_key = d.info_key);
   
insert into up_config_info
  (up_config_info_oid, info_key, info_value, Description)
  select up_config_info_SEQ.nextval as up_config_info_oid,
         info_key,
         info_value,
         Description
    from (select 
    'allinpay.xmlmessage.transaction.info.user_pass' as info_key, 
    '111111' as info_value, 
    '通联支付报文的密码' as Description
            from dual) d
   where not exists
   (select 1 from up_config_info t where t.info_key = d.info_key);
   
insert into up_config_info
  (up_config_info_oid, info_key, info_value, Description)
  select up_config_info_SEQ.nextval as up_config_info_oid,
         info_key,
         info_value,
         Description
    from (select 
    'allinpay.xmlmessage.transaction.body.bussiness_code' as info_key, 
    '19900' as info_value, 
    '通联支付报文的代付业务代码' as Description
            from dual) d
   where not exists
   (select 1 from up_config_info t where t.info_key = d.info_key);
   
insert into up_config_info
  (up_config_info_oid, info_key, info_value, Description)
  select up_config_info_SEQ.nextval as up_config_info_oid,
         info_key,
         info_value,
         Description
    from (select 
    'allinpay.xmlmessage.transaction.body.merchant_id' as info_key, 
    '200604000000445' as info_value, 
    '通联支付报文的商户号' as Description
            from dual) d
   where not exists
   (select 1 from up_config_info t where t.info_key = d.info_key);
   
insert into up_config_info
  (up_config_info_oid, info_key, info_value, Description)
  select up_config_info_SEQ.nextval as up_config_info_oid,
         info_key,
         info_value,
         Description
    from (select 
    'allinpay.xmlmessage.transaction.body.account_type' as info_key, 
    '00' as info_value, 
    '通联支付报文的默认账号类型：[00-银行卡 01-存折 02-信用卡]  ' as Description
            from dual) d
   where not exists
   (select 1 from up_config_info t where t.info_key = d.info_key);         
   
insert into up_config_info
  (up_config_info_oid, info_key, info_value, Description)
  select up_config_info_SEQ.nextval as up_config_info_oid,
         info_key,
         info_value,
         Description
    from (select 
    'allinpay.xmlmessage.transaction.body.account_prop' as info_key, 
    '0' as info_value, 
    '通联支付报文的默认账号类型：[0-私人 1-公司]  ' as Description
            from dual) d
   where not exists
   (select 1 from up_config_info t where t.info_key = d.info_key);   
   
        
insert into up_config_info
  (up_config_info_oid, info_key, info_value, Description)
  select up_config_info_SEQ.nextval as up_config_info_oid,
         info_key,
         info_value,
         Description
    from (select 
    'allinpay.xmlmessage.transaction.common.batch_size' as info_key, 
    '100' as info_value, 
    '通联支付报文的批次大小' as Description
            from dual) d
   where not exists
   (select 1 from up_config_info t where t.info_key = d.info_key);   

  
 insert into up_config_info
  (up_config_info_oid, info_key, info_value, Description)
  select up_config_info_SEQ.nextval as up_config_info_oid,
         info_key,
         info_value,
         Description
    from (select 
    'allinpay.xmlmessage.transaction.common.pfxPath' as info_key, 
    '20060400000044502.p12' as info_value, 
    '通联支付报文的签名文件' as Description
            from dual) d
   where not exists
   (select 1 from up_config_info t where t.info_key = d.info_key);   
   
  
insert into up_config_info
  (up_config_info_oid, info_key, info_value, Description)
  select up_config_info_SEQ.nextval as up_config_info_oid,
         info_key,
         info_value,
         Description
    from (select 
    'allinpay.xmlmessage.transaction.common.tltcerPath' as info_key, 
    'allinpay-pds.cer' as info_value, 
    '通联支付报文的数字证书' as Description
            from dual) d
   where not exists
   (select 1 from up_config_info t where t.info_key = d.info_key);    
   
insert into up_config_info
  (up_config_info_oid, info_key, info_value, Description)
  select up_config_info_SEQ.nextval as up_config_info_oid,
         info_key,
         info_value,
         Description
    from (select 
    'allinpay.xmlmessage.transaction.common.pfxPassword' as info_key, 
    '111111' as info_value, 
    '通联支付用户密码' as Description
            from dual) d
   where not exists
   (select 1 from up_config_info t where t.info_key = d.info_key);    
   
   
   insert into up_config_info
  (up_config_info_oid, info_key, info_value, Description)
  select up_config_info_SEQ.nextval as up_config_info_oid,
         info_key,
         info_value,
         Description
    from (select 
    'allinpay.xmlmessage.transaction.info.query_trx_code' as info_key, 
    '200004' as info_value, 
    '通联查询报文的交易代码' as Description
            from dual) d
   where not exists
   (select 1 from up_config_info t where t.info_key = d.info_key);
   
   
   insert into up_config_info
  (up_config_info_oid, info_key, info_value, Description)
  select up_config_info_SEQ.nextval as up_config_info_oid,
         info_key,
         info_value,
         Description
    from (select 
    'allinpay.xmlmessage.transaction.common.tran.url' as info_key, 
    'https://113.108.182.3/aipg/ProcessServlet' as info_value, 
    '通联url' as Description
            from dual) d
   where not exists
   (select 1 from up_config_info t where t.info_key = d.info_key);  
   

   insert into up_config_info
  (up_config_info_oid, info_key, info_value, Description)
  select up_config_info_SEQ.nextval as up_config_info_oid,
         info_key,
         info_value,
         Description
    from (select 
    'allinpay.xmlmessage.transaction.common.batch.file.path' as info_key, 
    '/opt/IBM/WebSphere/AppServer/profiles/AppSrv01/logs/server1/AIPTranxFile' as info_value, 
    '通联代收批量代收请求文件路径' as Description
            from dual) d
   where not exists
   (select 1 from up_config_info t where t.info_key = d.info_key);  

   
      insert into up_config_info
  (up_config_info_oid, info_key, info_value, Description)
  select up_config_info_SEQ.nextval as up_config_info_oid,
         info_key,
         info_value,
         Description
    from (select 
    'allinpay.xmlmessage.transaction.common.query.file.path' as info_key, 
    '/opt/IBM/WebSphere/AppServer/profiles/AppSrv01/logs/server1/AIPQueryFile' as info_value, 
    '通联代收批量代收查询文件路径' as Description
            from dual) d
   where not exists
   (select 1 from up_config_info t where t.info_key = d.info_key);
   
   insert into up_config_info
  (up_config_info_oid, info_key, info_value, Description)
  select up_config_info_SEQ.nextval as up_config_info_oid,
         info_key,
         info_value,
         Description
    from (select 
    'cmb.rf.payment.file.path' as info_key, 
    '/opt/IBM/WebSphere/AppServer/profiles/AppSrv01/logs/server1/CMB/payment/' as info_value, 
    '招行代付文件路径' as Description
            from dual) d
   where not exists
   (select 1 from up_config_info t where t.info_key = d.info_key);
   
   insert into up_config_info
  (up_config_info_oid, info_key, info_value, Description)
  select up_config_info_SEQ.nextval as up_config_info_oid,
         info_key,
         info_value,
         Description
    from (select 
    'cmb.rf.payment.dbt.acc' as info_key, 
    '121910510510688' as info_value, 
    '招行付方帐号' as Description
            from dual) d
   where not exists
   (select 1 from up_config_info t where t.info_key = d.info_key);
   
   insert into up_config_info
  (up_config_info_oid, info_key, info_value, Description)
  select up_config_info_SEQ.nextval as up_config_info_oid,
         info_key,
         info_value,
         Description
    from (select 
    'cmb.rf.payment.dbt.bbk' as info_key, 
    '上海' as info_value, 
    '付方开户地区' as Description
            from dual) d
   where not exists
   (select 1 from up_config_info t where t.info_key = d.info_key); 


   insert into up_config_info
  (up_config_info_oid, info_key, info_value, Description)
  select up_config_info_SEQ.nextval as up_config_info_oid,
         info_key,
         info_value,
         Description
    from (select 
    'cmb.rf.payment.file.finance_smb_path' as info_key, 
    'smb://UAF.COM.CN;wb00004:Password123@10.168.11.250/fa_test/' as info_value, 
    '财务服务RF文档URL格式说明：smb://[域];[用户名]:[密码]@10.168.11.250/fa_test/' as Description
            from dual) d
   where not exists
   (select 1 from up_config_info t where t.info_key = d.info_key); 

   
   