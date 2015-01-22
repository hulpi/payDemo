drop table up_config_info cascade constraints;

/*==============================================================*/
/* Table: up_config_info                                        */
/*==============================================================*/
create table up_config_info 
(
   up_config_info_oid   numeric(19)          not null,
   info_key             varchar2(100),
   info_value           varchar2(500),
   Description          varchar2(200),
   constraint PK_UP_CONFIG_INFO primary key (up_config_info_oid)
);

alter table up_config_info
  add constraint UK_up_config_info unique (info_key);
