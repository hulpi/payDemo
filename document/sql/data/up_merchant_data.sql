insert into up_merchant 
  (up_merchant_oid,
     merchant_code,
     city_code,  
     city_name,   
     account_no,         
     account_name,        
     bank_code,           
     bank_name,          
     bank_province,    
     bank_city,           
     remark) 
  select up_merchant_SEQ.nextval as up_merchant_oid,
     merchant_code,
     city_code,  
     city_name,   
     account_no,         
     account_name,        
     bank_code,           
     bank_name,          
     bank_province,    
     bank_city,           
     remark
    from (select  
     '200604000000445' as merchant_code,
     '01' as city_code,  
     '深圳' as city_name,   
     '' as account_no,         
     '' as account_name,        
     '' as bank_code,           
     '' as bank_name,          
     '' as bank_province,    
     '' as bank_city,           
     '' as remark 
   from dual) d
   where not exists 
   (select 1 from up_merchant t where t.city_code = d.city_code);

   insert into up_merchant 
  (up_merchant_oid,
     merchant_code,
     city_code,  
     city_name,   
     account_no,         
     account_name,        
     bank_code,           
     bank_name,          
     bank_province,    
     bank_city,           
     remark) 
  select up_merchant_SEQ.nextval as up_merchant_oid,
     merchant_code,
     city_code,  
     city_name,   
     account_no,         
     account_name,        
     bank_code,           
     bank_name,          
     bank_province,    
     bank_city,           
     remark
    from (select  
     '200604000000445' as merchant_code,
     '02' as city_code,  
     '广州' as city_name,   
     '' as account_no,         
     '' as account_name,        
     '' as bank_code,           
     '' as bank_name,          
     '' as bank_province,    
     '' as bank_city,           
     '' as remark 
   from dual) d
   where not exists 
   (select 1 from up_merchant t where t.city_code = d.city_code);

   