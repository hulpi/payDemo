drop table up_log_info cascade constraints;

/*==============================================================*/
/* Table: up_log_info                                           */
/*==============================================================*/
create table up_log_info 
(
   up_log_info_oid      numeric(19)          not null,
   type                 VARCHAR2(2),
   content              VARCHAR2(1000),
   creator              VARCHAR2(50),
   create_date          date,
   constraint PK_UP_LOG_INFO primary key (up_log_info_oid)
);
