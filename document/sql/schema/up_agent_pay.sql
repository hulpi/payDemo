
drop table up_agent_pay cascade constraints;

/*==============================================================*/
/* Table: up_agent_pay                                          */
/*==============================================================*/
create table up_agent_pay 
(
   up_agent_pay_oid     numeric(19),
   agent_pay_code       VARCHAR2(10),
   agent_pay_name       VARCHAR2(100),
   remark               VARCHAR2(200),
   constraint PK_up_agent_pay primary key (up_agent_pay_oid)
);


alter table up_agent_pay
  add constraint UK_up_agent_pay unique (agent_pay_code);
  
