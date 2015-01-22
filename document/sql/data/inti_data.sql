select 'execute @up_agent_pay_data.sql' from dual;
@up_agent_pay_data.sql

select 'execute @up_config_info_data.sql' from dual;
@up_config_info_data.sql

select 'execute @up_sys_register_data.sql' from dual;
@up_sys_register_data.sql

select 'execute @up_merchant_data.sql' from dual;
@up_merchant_data.sql

select 'execute @up_bank_mapping_data.sql' from dual;
@up_bank_mapping_data.sql

commit;