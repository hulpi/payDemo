drop table up_batch_process cascade constraints;

/*==============================================================*/
/* Table: up_batch_process                                      */
/*==============================================================*/
create table up_batch_process 
(
   up_batch_process_oid numeric(19)          not null,
   file_path            varchar2(1000),
   total_item           int,
   total_sum            numeric(30,2),
   req_sn               varchar2(40),
   return_code          varchar2(10),
   status               varchar2(4),
   error_msg            varchar2(1000),
   create_date          date,
   constraint PK_UP_BATCH_PROCESS primary key (up_batch_process_oid)
);

alter table up_batch_process
  add constraint UK_up_batch_process unique (req_sn);
  