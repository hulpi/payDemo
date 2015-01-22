insert into up_agent_pay
  (up_agent_pay_oid, agent_pay_code, agent_pay_name, remark)
  select up_agent_pay_SEQ.nextval as up_agent_pay_oid,
         agent_pay_code, agent_pay_name, remark 
    from (select  
    '01' as agent_pay_code, 
    '通联支付' as agent_pay_name, 
    '通联代理收付合作方' as remark
            from dual) d
   where not exists
   (select 1 from up_agent_pay t where t.agent_pay_code = d.agent_pay_code);
   
   
insert into up_agent_pay
  (up_agent_pay_oid, agent_pay_code, agent_pay_name, remark)
  select up_agent_pay_SEQ.nextval as up_agent_pay_oid,
         agent_pay_code, agent_pay_name, remark 
    from (select 
    '02' as agent_pay_code, 
    '招商支付' as agent_pay_name, 
    '招商银行代理收付合作方' as remark
            from dual) d
   where not exists
   (select 1 from up_agent_pay t where t.agent_pay_code = d.agent_pay_code);
  
  