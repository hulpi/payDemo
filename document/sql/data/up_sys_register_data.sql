insert into up_sys_register
  (up_sys_register_oid, sys_register_code, sys_name, status, remark)
  select up_sys_register_SEQ.nextval as up_agent_pay_oid,
         sys_register_code, sys_name, status, remark
    from (select 
    '10001234' as sys_register_code, 
    '担保系统' as sys_name, 
    '1' as status,
    ''as remark
            from dual) d
   where not exists
   (select 1 from up_sys_register t where t.sys_register_code = d.sys_register_code);
   
   
   
  
  