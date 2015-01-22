
drop table up_batch_query_detail cascade constraints;

/*==============================================================*/
/* Table: up_batch_query_detail                                 */
/*==============================================================*/
create table up_batch_query_detail 
(
   up_batch_query_detail_oid numeric(19)          not null,
   up_batch_query_oid   numeric(19),
   up_transaction_oid   numeric(19),
   sn                   varchar2(4),
   trx_dir              varchar2(1),
   settday              varchar2(16),
   finish_time          varchar2(20),
   submit_time          varchar2(20),
   account_no           varchar2(32),
   account_name         varchar2(60),
   amount               numeric(10,2),
   cust_user_id         varchar2(128),
   remark               varchar2(50),
   return_code          varchar2(10),
   error_msg            varchar2(1000),
   create_date          date,
   constraint PK_UP_BATCH_QUERY_DETAIL primary key (up_batch_query_detail_oid)
);

