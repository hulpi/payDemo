alter table UP_TRANSACTION
  add constraint FK1_UP_TRANSACTION foreign key (UP_SYS_REGISTER_OID)
  references UP_SYS_REGISTER (UP_SYS_REGISTER_OID);
  
alter table UP_TRANSACTION
  add constraint FK2_UP_TRANSACTION foreign key (UP_AGENT_PAY_OID)
  references UP_AGENT_PAY (UP_AGENT_PAY_OID);
  
alter table UP_TRANSACTION
  add constraint FK3_UP_TRANSACTION foreign key (UP_MERCHANT_OID)
  references UP_MERCHANT (UP_MERCHANT_OID);

----
alter table UP_BATCH_PROCESS_DETAIL
  add constraint FK1_UP_BATCH_PROCESS_DETAIL foreign key (UP_BATCH_PROCESS_OID)
  references UP_BATCH_PROCESS (UP_BATCH_PROCESS_OID);
  
alter table UP_BATCH_PROCESS_DETAIL
  add constraint FK2_UP_BATCH_PROCESS_DETAIL foreign key (UP_TRANSACTION_OID)
  references UP_TRANSACTION (UP_TRANSACTION_OID);


----
alter table UP_BATCH_QUERY
  add constraint FK1_UP_BATCH_QUERY foreign key (UP_BATCH_PROCESS_OID)
  references UP_BATCH_PROCESS (UP_BATCH_PROCESS_OID);

----  
alter table UP_BATCH_QUERY_DETAIL
  add constraint FK1_UP_BATCH_QUERY_DETAIL foreign key (UP_BATCH_QUERY_OID)
  references UP_BATCH_QUERY (UP_BATCH_QUERY_OID);
  
alter table UP_BATCH_QUERY_DETAIL
  add constraint FK2_UP_BATCH_QUERY_DETAIL foreign key (UP_TRANSACTION_OID)
  references UP_TRANSACTION (UP_TRANSACTION_OID);
  
