
drop table up_batch_process_detail cascade constraints;

/*==============================================================*/
/* Table: up_batch_process_detail                               */
/*==============================================================*/
create table up_batch_process_detail 
(
   up_batch_process_detail_oid numeric(19)          not null,
   up_batch_process_oid numeric(19),
   up_transaction_oid   numeric(19),
   sn                   varchar2(10),
   return_code          varchar2(10),
   error_msg            varchar2(1000),
   create_date          date,
   constraint PK_UP_BATCH_PROCESS_DETAIL primary key (up_batch_process_detail_oid)
);

