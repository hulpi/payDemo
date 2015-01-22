
drop table up_batch_query cascade constraints;

/*==============================================================*/
/* Table: up_batch_query                                        */
/*==============================================================*/
create table up_batch_query 
(
   up_batch_query_oid   numeric(19)          not null,
   up_batch_process_oid numeric(19),
   file_path            varchar2(1000),
   req_sn               varchar2(40),
   return_code          varchar2(10),
   error_msg            varchar2(500),
   create_date          date,
   constraint PK_UP_BATCH_QUERY primary key (up_batch_query_oid)
);

 
alter table up_batch_query
  add constraint UK_UP_BATCH_QUERY unique (req_sn);
  