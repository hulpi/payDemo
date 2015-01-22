
drop table up_merchant cascade constraints;

/*==============================================================*/
/* Table: up_merchant                                           */
/*==============================================================*/
create table up_merchant 
(
   up_merchant_oid      numeric(19),
   merchant_code        varchar2(50),
   city_code            varchar2(40),
   city_name            varchar2(50),
   account_no           varchar2(40),
   account_name         varchar2(2),
   bank_code            varchar2(3),
   bank_name            varchar2(60),
   bank_province        varchar2(10),
   bank_city            varchar2(20),
   remark               varchar2(200),
   constraint PK_up_merchant primary key(up_merchant_oid)
);

alter table up_merchant
  add constraint UK_up_merchant unique (city_code);