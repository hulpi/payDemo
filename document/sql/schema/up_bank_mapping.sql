drop table up_bank_mapping cascade constraints;

/*==============================================================*/
/* Table: up_bank_mapping                                       */
/*==============================================================*/
create table up_bank_mapping 
(
   up_bank_mapping_oid  NUMBER(19)           not null,
   original_bank_code   VARCHAR2(30),
   destined_bank_code   VARCHAR2(30),
   purpose_type         VARCHAR2(2),
   bank_name            VARCHAR2(100),
   remark               VARCHAR2(200),
   constraint PK_UP_BANK_MAPPING primary key (up_bank_mapping_oid)
);

alter table up_bank_mapping
  add constraint UK_up_bank_mapping unique (original_bank_code, purpose_type);