
drop table up_transaction cascade constraints;

/*==============================================================*/
/* Table: up_transaction                                        */
/*==============================================================*/

create table up_transaction 
(
   up_transaction_oid   numeric(19)          not null,
   up_sys_register_oid  numeric(19)          ,
   uf_app_ledg_seq_id   varchar2(40),
   uf_send_batch_id     varchar2(50),
   uf_app_code          varchar2(50),
   uf_city_code         varchar2(10),
   up_agent_pay_oid     numeric(19),
   pay_type             varchar2(2),
   up_merchant_oid      numeric(19),
   reference_no         varchar2(50),
   account_no           varchar2(40),
   account_name         varchar2(30),
   account_cert_type	varchar2(20), 
   bank_code            varchar2(30),
   bank_name            varchar2(60),
   bank_province        varchar2(10),
   bank_city            varchar2(20),
   settle_type          varchar2(20),
   amount               numeric(10,2),
   currency             varchar2(6),
   expect_settle_date   date,
   actual_settle_date   date,
   status               varchar2(2),
   version_no           int,
   remark               varchar2(200),
   create_date          date,
   constraint PK_UP_TRANSACTION primary key (up_transaction_oid)
);

