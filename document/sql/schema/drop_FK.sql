alter table UP_TRANSACTION
  drop constraint FK1_UP_TRANSACTION;
  
alter table UP_TRANSACTION
  drop constraint FK2_UP_TRANSACTION;
  
alter table UP_TRANSACTION
  drop constraint FK3_UP_TRANSACTION;

----
alter table UP_BATCH_PROCESS_DETAIL
  drop constraint FK1_UP_BATCH_PROCESS_DETAIL;
  
alter table UP_BATCH_PROCESS_DETAIL
  drop constraint FK2_UP_BATCH_PROCESS_DETAIL;

----
alter table UP_BATCH_QUERY
  drop constraint FK1_UP_BATCH_QUERY;

----  
alter table UP_BATCH_QUERY_DETAIL
  drop constraint FK1_UP_BATCH_QUERY_DETAIL;
  
alter table UP_BATCH_QUERY_DETAIL
  drop constraint FK2_UP_BATCH_QUERY_DETAIL;
 
 ----