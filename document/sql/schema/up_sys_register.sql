
drop table up_sys_register cascade constraints;

/*==============================================================*/
/* Table: up_sys_register                                       */
/*==============================================================*/
create table up_sys_register 
(
   up_sys_register_oid  numeric(19),
   sys_register_code    varchar2(12),
   sys_name             varchar2(20),
   status               varchar2(2),
   remark               varchar2(200),
   constraint PK_up_sys_register primary key (up_sys_register_oid)
);


alter table up_sys_register
  add constraint UK_up_sys_register unique (sys_register_code);
  