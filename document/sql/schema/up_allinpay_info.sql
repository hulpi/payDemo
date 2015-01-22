
drop table up_allinpay_info cascade constraints;

/*==============================================================*/
/* Table: up_allinpay_info                                      */
/*==============================================================*/
create table up_allinpay_info 
(
   up_allinpay_info_oid numeric(19)          not null,
   up_transaction_oid   numeric(19)          not null,
   e_user_code          varchar2(20),
   protocol             varchar2(60),
   protocol_user        varchar2(30),
   id_type              varchar2(1),
   id_number            varchar2(22),
   tel                  varchar2(13),
   cust_user_id         varchar2(128),
   settacct             varchar2(32),
   remark               varchar2(50),
   settgroup_flag       varchar2(30),
   summary              varchar2(140),
   union_bank           varchar2(12),
   create_date          date,
   constraint PK_UP_ALLINPAY_INFO primary key (up_allinpay_info_oid)
);

alter table up_allinpay_info
  add constraint UK_up_allinpay_info unique (up_transaction_oid);
