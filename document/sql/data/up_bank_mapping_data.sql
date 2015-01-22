--01
insert into up_bank_mapping
  (up_bank_mapping_oid,
   original_bank_code,
   destined_bank_code,
   purpose_type,
   bank_name,
   remark)
  select up_bank_mapping_SEQ.nextval as up_bank_mapping_oid,
         original_bank_code,
         destined_bank_code,
         purpose_type,
         bank_name,
         remark
    from (select '01' as original_bank_code,
                 '4031000' as destined_bank_code,
                 '1' as purpose_type,
                 '北京银行' as bank_name,
                 '深圳、广州' as remark
            from dual) d
   where not exists (select 1
            from up_bank_mapping t
           where t.original_bank_code = d.original_bank_code
             and t.purpose_type = d.purpose_type);

--02    
insert into up_bank_mapping
  (up_bank_mapping_oid,
   original_bank_code,
   destined_bank_code,
   purpose_type,
   bank_name,
   remark)
  select up_bank_mapping_SEQ.nextval as up_bank_mapping_oid,
         original_bank_code,
         destined_bank_code,
         purpose_type,
         bank_name,
         remark
    from (select '02' as original_bank_code,
                 '304' as destined_bank_code,
                 '1' as purpose_type,
                 '华夏银行' as bank_name,
                 '深圳、广州' as remark
            from dual) d
   where not exists (select 1
            from up_bank_mapping t
           where t.original_bank_code = d.original_bank_code
             and t.purpose_type = d.purpose_type);

--03   
insert into up_bank_mapping
  (up_bank_mapping_oid,
   original_bank_code,
   destined_bank_code,
   purpose_type,
   bank_name,
   remark)
  select up_bank_mapping_SEQ.nextval as up_bank_mapping_oid,
         original_bank_code,
         destined_bank_code,
         purpose_type,
         bank_name,
         remark
    from (select '03' as original_bank_code,
                 '103' as destined_bank_code,
                 '1' as purpose_type,
                 '农业银行' as bank_name,
                 '深圳、广州' as remark
            from dual) d
   where not exists (select 1
            from up_bank_mapping t
           where t.original_bank_code = d.original_bank_code
             and t.purpose_type = d.purpose_type);

--04    
insert into up_bank_mapping
  (up_bank_mapping_oid,
   original_bank_code,
   destined_bank_code,
   purpose_type,
   bank_name,
   remark)
  select up_bank_mapping_SEQ.nextval as up_bank_mapping_oid,
         original_bank_code,
         destined_bank_code,
         purpose_type,
         bank_name,
         remark
    from (select '04' as original_bank_code,
                 '104' as destined_bank_code,
                 '1' as purpose_type,
                 '中国银行' as bank_name,
                 '深圳、广州' as remark
            from dual) d
   where not exists (select 1
            from up_bank_mapping t
           where t.original_bank_code = d.original_bank_code
             and t.purpose_type = d.purpose_type);

--05
insert into up_bank_mapping
  (up_bank_mapping_oid,
   original_bank_code,
   destined_bank_code,
   purpose_type,
   bank_name,
   remark)
  select up_bank_mapping_SEQ.nextval as up_bank_mapping_oid,
         original_bank_code,
         destined_bank_code,
         purpose_type,
         bank_name,
         remark
    from (select '05' as original_bank_code,
                 '105' as destined_bank_code,
                 '1' as purpose_type,
                 '建设银行' as bank_name,
                 '深圳、广州' as remark
            from dual) d
   where not exists (select 1
            from up_bank_mapping t
           where t.original_bank_code = d.original_bank_code
             and t.purpose_type = d.purpose_type);

--06
insert into up_bank_mapping
  (up_bank_mapping_oid,
   original_bank_code,
   destined_bank_code,
   purpose_type,
   bank_name,
   remark)
  select up_bank_mapping_SEQ.nextval as up_bank_mapping_oid,
         original_bank_code,
         destined_bank_code,
         purpose_type,
         bank_name,
         remark
    from (select '06' as original_bank_code,
                 '301' as destined_bank_code,
                 '1' as purpose_type,
                 '交通银行' as bank_name,
                 '深圳、广州' as remark
            from dual) d
   where not exists (select 1
            from up_bank_mapping t
           where t.original_bank_code = d.original_bank_code
             and t.purpose_type = d.purpose_type);

--07
insert into up_bank_mapping
  (up_bank_mapping_oid,
   original_bank_code,
   destined_bank_code,
   purpose_type,
   bank_name,
   remark)
  select up_bank_mapping_SEQ.nextval as up_bank_mapping_oid,
         original_bank_code,
         destined_bank_code,
         purpose_type,
         bank_name,
         remark
    from (select '07' as original_bank_code,
                 '302' as destined_bank_code,
                 '1' as purpose_type,
                 '中信银行' as bank_name,
                 '深圳、广州' as remark
            from dual) d
   where not exists (select 1
            from up_bank_mapping t
           where t.original_bank_code = d.original_bank_code
             and t.purpose_type = d.purpose_type);

--08
insert into up_bank_mapping
  (up_bank_mapping_oid,
   original_bank_code,
   destined_bank_code,
   purpose_type,
   bank_name,
   remark)
  select up_bank_mapping_SEQ.nextval as up_bank_mapping_oid,
         original_bank_code,
         destined_bank_code,
         purpose_type,
         bank_name,
         remark
    from (select '08' as original_bank_code,
                 '403' as destined_bank_code,
                 '1' as purpose_type,
                 '邮蓄银行' as bank_name,
                 '深圳、广州' as remark
            from dual) d
   where not exists (select 1
            from up_bank_mapping t
           where t.original_bank_code = d.original_bank_code
             and t.purpose_type = d.purpose_type);

--09
insert into up_bank_mapping
  (up_bank_mapping_oid,
   original_bank_code,
   destined_bank_code,
   purpose_type,
   bank_name,
   remark)
  select up_bank_mapping_SEQ.nextval as up_bank_mapping_oid,
         original_bank_code,
         destined_bank_code,
         purpose_type,
         bank_name,
         remark
    from (select '09' as original_bank_code,
                 '308' as destined_bank_code,
                 '1' as purpose_type,
                 '招商银行' as bank_name,
                 '深圳、广州' as remark
            from dual) d
   where not exists (select 1
            from up_bank_mapping t
           where t.original_bank_code = d.original_bank_code
             and t.purpose_type = d.purpose_type);

--10
insert into up_bank_mapping
  (up_bank_mapping_oid,
   original_bank_code,
   destined_bank_code,
   purpose_type,
   bank_name,
   remark)
  select up_bank_mapping_SEQ.nextval as up_bank_mapping_oid,
         original_bank_code,
         destined_bank_code,
         purpose_type,
         bank_name,
         remark
    from (select '10' as original_bank_code,
                 '306' as destined_bank_code,
                 '1' as purpose_type,
                 '光大银行' as bank_name,
                 '深圳、广州' as remark
            from dual) d
   where not exists (select 1
            from up_bank_mapping t
           where t.original_bank_code = d.original_bank_code
             and t.purpose_type = d.purpose_type);

--11
insert into up_bank_mapping
  (up_bank_mapping_oid,
   original_bank_code,
   destined_bank_code,
   purpose_type,
   bank_name,
   remark)
  select up_bank_mapping_SEQ.nextval as up_bank_mapping_oid,
         original_bank_code,
         destined_bank_code,
         purpose_type,
         bank_name,
         remark
    from (select '11' as original_bank_code,
                 '4105840' as destined_bank_code,
                 '1' as purpose_type,
                 '光大银行' as bank_name,
                 '深圳、广州' as remark
            from dual) d
   where not exists (select 1
            from up_bank_mapping t
           where t.original_bank_code = d.original_bank_code
             and t.purpose_type = d.purpose_type);

--12
insert into up_bank_mapping
  (up_bank_mapping_oid,
   original_bank_code,
   destined_bank_code,
   purpose_type,
   bank_name,
   remark)
  select up_bank_mapping_SEQ.nextval as up_bank_mapping_oid,
         original_bank_code,
         destined_bank_code,
         purpose_type,
         bank_name,
         remark
    from (select '12' as original_bank_code,
                 '4105840' as destined_bank_code,
                 '1' as purpose_type,
                 '平安银行' as bank_name,
                 '深圳、广州' as remark
            from dual) d
   where not exists (select 1
            from up_bank_mapping t
           where t.original_bank_code = d.original_bank_code
             and t.purpose_type = d.purpose_type);

--13
insert into up_bank_mapping
  (up_bank_mapping_oid,
   original_bank_code,
   destined_bank_code,
   purpose_type,
   bank_name,
   remark)
  select up_bank_mapping_SEQ.nextval as up_bank_mapping_oid,
         original_bank_code,
         destined_bank_code,
         purpose_type,
         bank_name,
         remark
    from (select '13' as original_bank_code,
                 '309' as destined_bank_code,
                 '1' as purpose_type,
                 '兴业银行' as bank_name,
                 '深圳、广州' as remark
            from dual) d
   where not exists (select 1
            from up_bank_mapping t
           where t.original_bank_code = d.original_bank_code
             and t.purpose_type = d.purpose_type);

--14
insert into up_bank_mapping
  (up_bank_mapping_oid,
   original_bank_code,
   destined_bank_code,
   purpose_type,
   bank_name,
   remark)
  select up_bank_mapping_SEQ.nextval as up_bank_mapping_oid,
         original_bank_code,
         destined_bank_code,
         purpose_type,
         bank_name,
         remark
    from (select '14' as original_bank_code,
                 '310' as destined_bank_code,
                 '1' as purpose_type,
                 '浦发银行' as bank_name,
                 '深圳、广州' as remark
            from dual) d
   where not exists (select 1
            from up_bank_mapping t
           where t.original_bank_code = d.original_bank_code
             and t.purpose_type = d.purpose_type);

--15
insert into up_bank_mapping
  (up_bank_mapping_oid,
   original_bank_code,
   destined_bank_code,
   purpose_type,
   bank_name,
   remark)
  select up_bank_mapping_SEQ.nextval as up_bank_mapping_oid,
         original_bank_code,
         destined_bank_code,
         purpose_type,
         bank_name,
         remark
    from (select '15' as original_bank_code,
                 '305' as destined_bank_code,
                 '1' as purpose_type,
                 '民生银行' as bank_name,
                 '深圳、广州' as remark
            from dual) d
   where not exists (select 1
            from up_bank_mapping t
           where t.original_bank_code = d.original_bank_code
             and t.purpose_type = d.purpose_type);

--16
insert into up_bank_mapping
  (up_bank_mapping_oid,
   original_bank_code,
   destined_bank_code,
   purpose_type,
   bank_name,
   remark)
  select up_bank_mapping_SEQ.nextval as up_bank_mapping_oid,
         original_bank_code,
         destined_bank_code,
         purpose_type,
         bank_name,
         remark
    from (select '16' as original_bank_code,
                 '4643970' as destined_bank_code,
                 '1' as purpose_type,
                 '泉州银行' as bank_name,
                 '深圳、广州' as remark
            from dual) d
   where not exists (select 1
            from up_bank_mapping t
           where t.original_bank_code = d.original_bank_code
             and t.purpose_type = d.purpose_type);

--17
insert into up_bank_mapping
  (up_bank_mapping_oid,
   original_bank_code,
   destined_bank_code,
   purpose_type,
   bank_name,
   remark)
  select up_bank_mapping_SEQ.nextval as up_bank_mapping_oid,
         original_bank_code,
         destined_bank_code,
         purpose_type,
         bank_name,
         remark
    from (select '17' as original_bank_code,
                 '04484220' as destined_bank_code,
                 '1' as purpose_type,
                 '南昌银行' as bank_name,
                 '深圳、广州' as remark
            from dual) d
   where not exists (select 1
            from up_bank_mapping t
           where t.original_bank_code = d.original_bank_code
             and t.purpose_type = d.purpose_type);

--18
insert into up_bank_mapping
  (up_bank_mapping_oid,
   original_bank_code,
   destined_bank_code,
   purpose_type,
   bank_name,
   remark)
  select up_bank_mapping_SEQ.nextval as up_bank_mapping_oid,
         original_bank_code,
         destined_bank_code,
         purpose_type,
         bank_name,
         remark
    from (select '18' as original_bank_code,
                 '' as destined_bank_code,
                 '1' as purpose_type,
                 '大连银行' as bank_name,
                 '深圳、广州' as remark
            from dual) d
   where not exists (select 1
            from up_bank_mapping t
           where t.original_bank_code = d.original_bank_code
             and t.purpose_type = d.purpose_type);

--19
insert into up_bank_mapping
  (up_bank_mapping_oid,
   original_bank_code,
   destined_bank_code,
   purpose_type,
   bank_name,
   remark)
  select up_bank_mapping_SEQ.nextval as up_bank_mapping_oid,
         original_bank_code,
         destined_bank_code,
         purpose_type,
         bank_name,
         remark
    from (select '19' as original_bank_code,
                 '03136650' as destined_bank_code,
                 '1' as purpose_type,
                 '乐山银行' as bank_name,
                 '深圳、广州' as remark
            from dual) d
   where not exists (select 1
            from up_bank_mapping t
           where t.original_bank_code = d.original_bank_code
             and t.purpose_type = d.purpose_type);

--20
insert into up_bank_mapping
  (up_bank_mapping_oid,
   original_bank_code,
   destined_bank_code,
   purpose_type,
   bank_name,
   remark)
  select up_bank_mapping_SEQ.nextval as up_bank_mapping_oid,
         original_bank_code,
         destined_bank_code,
         purpose_type,
         bank_name,
         remark
    from (select '20' as original_bank_code,
                 '04083320' as destined_bank_code,
                 '1' as purpose_type,
                 '宁波银行' as bank_name,
                 '深圳、广州' as remark
            from dual) d
   where not exists (select 1
            from up_bank_mapping t
           where t.original_bank_code = d.original_bank_code
             and t.purpose_type = d.purpose_type);

--21
insert into up_bank_mapping
  (up_bank_mapping_oid,
   original_bank_code,
   destined_bank_code,
   purpose_type,
   bank_name,
   remark)
  select up_bank_mapping_SEQ.nextval as up_bank_mapping_oid,
         original_bank_code,
         destined_bank_code,
         purpose_type,
         bank_name,
         remark
    from (select '21' as original_bank_code,
                 '04256020' as destined_bank_code,
                 '1' as purpose_type,
                 '东莞银行' as bank_name,
                 '深圳、广州' as remark
            from dual) d
   where not exists (select 1
            from up_bank_mapping t
           where t.original_bank_code = d.original_bank_code
             and t.purpose_type = d.purpose_type);

--22
insert into up_bank_mapping
  (up_bank_mapping_oid,
   original_bank_code,
   destined_bank_code,
   purpose_type,
   bank_name,
   remark)
  select up_bank_mapping_SEQ.nextval as up_bank_mapping_oid,
         original_bank_code,
         destined_bank_code,
         purpose_type,
         bank_name,
         remark
    from (select '22' as original_bank_code,
                 '' as destined_bank_code,
                 '1' as purpose_type,
                 '郑州银行' as bank_name,
                 '深圳、广州' as remark
            from dual) d
   where not exists (select 1
            from up_bank_mapping t
           where t.original_bank_code = d.original_bank_code
             and t.purpose_type = d.purpose_type);

--23
insert into up_bank_mapping
  (up_bank_mapping_oid,
   original_bank_code,
   destined_bank_code,
   purpose_type,
   bank_name,
   remark)
  select up_bank_mapping_SEQ.nextval as up_bank_mapping_oid,
         original_bank_code,
         destined_bank_code,
         purpose_type,
         bank_name,
         remark
    from (select '23' as original_bank_code,
                 '04856590' as destined_bank_code,
                 '1' as purpose_type,
                 '绵阳银行' as bank_name,
                 '深圳、广州' as remark
            from dual) d
   where not exists (select 1
            from up_bank_mapping t
           where t.original_bank_code = d.original_bank_code
             and t.purpose_type = d.purpose_type);

--24
insert into up_bank_mapping
  (up_bank_mapping_oid,
   original_bank_code,
   destined_bank_code,
   purpose_type,
   bank_name,
   remark)
  select up_bank_mapping_SEQ.nextval as up_bank_mapping_oid,
         original_bank_code,
         destined_bank_code,
         purpose_type,
         bank_name,
         remark
    from (select '24' as original_bank_code,
                 '04243010' as destined_bank_code,
                 '1' as purpose_type,
                 '南京银行' as bank_name,
                 '深圳、广州' as remark
            from dual) d
   where not exists (select 1
            from up_bank_mapping t
           where t.original_bank_code = d.original_bank_code
             and t.purpose_type = d.purpose_type);

--25
insert into up_bank_mapping
  (up_bank_mapping_oid,
   original_bank_code,
   destined_bank_code,
   purpose_type,
   bank_name,
   remark)
  select up_bank_mapping_SEQ.nextval as up_bank_mapping_oid,
         original_bank_code,
         destined_bank_code,
         purpose_type,
         bank_name,
         remark
    from (select '25' as original_bank_code,
                 '4437010' as destined_bank_code,
                 '1' as purpose_type,
                 '贵阳银行' as bank_name,
                 '深圳、广州' as remark
            from dual) d
   where not exists (select 1
            from up_bank_mapping t
           where t.original_bank_code = d.original_bank_code
             and t.purpose_type = d.purpose_type);

--26
insert into up_bank_mapping
  (up_bank_mapping_oid,
   original_bank_code,
   destined_bank_code,
   purpose_type,
   bank_name,
   remark)
  select up_bank_mapping_SEQ.nextval as up_bank_mapping_oid,
         original_bank_code,
         destined_bank_code,
         purpose_type,
         bank_name,
         remark
    from (select '26' as original_bank_code,
                 '' as destined_bank_code,
                 '1' as purpose_type,
                 '重庆农商' as bank_name,
                 '深圳、广州' as remark
            from dual) d
   where not exists (select 1
            from up_bank_mapping t
           where t.original_bank_code = d.original_bank_code
             and t.purpose_type = d.purpose_type);

--27
insert into up_bank_mapping
  (up_bank_mapping_oid,
   original_bank_code,
   destined_bank_code,
   purpose_type,
   bank_name,
   remark)
  select up_bank_mapping_SEQ.nextval as up_bank_mapping_oid,
         original_bank_code,
         destined_bank_code,
         purpose_type,
         bank_name,
         remark
    from (select '27' as original_bank_code,
                 '04025350' as destined_bank_code,
                 '1' as purpose_type,
                 '湖北农信' as bank_name,
                 '深圳、广州' as remark
            from dual) d
   where not exists (select 1
            from up_bank_mapping t
           where t.original_bank_code = d.original_bank_code
             and t.purpose_type = d.purpose_type);

--28
insert into up_bank_mapping
  (up_bank_mapping_oid,
   original_bank_code,
   destined_bank_code,
   purpose_type,
   bank_name,
   remark)
  select up_bank_mapping_SEQ.nextval as up_bank_mapping_oid,
         original_bank_code,
         destined_bank_code,
         purpose_type,
         bank_name,
         remark
    from (select '28' as original_bank_code,
                 '14144500' as destined_bank_code,
                 '1' as purpose_type,
                 '山东农信' as bank_name,
                 '深圳、广州' as remark
            from dual) d
   where not exists (select 1
            from up_bank_mapping t
           where t.original_bank_code = d.original_bank_code
             and t.purpose_type = d.purpose_type);

--29
insert into up_bank_mapping
  (up_bank_mapping_oid,
   original_bank_code,
   destined_bank_code,
   purpose_type,
   bank_name,
   remark)
  select up_bank_mapping_SEQ.nextval as up_bank_mapping_oid,
         original_bank_code,
         destined_bank_code,
         purpose_type,
         bank_name,
         remark
    from (select '29' as original_bank_code,
                 '04023610' as destined_bank_code,
                 '1' as purpose_type,
                 '安徽农信' as bank_name,
                 '深圳、广州' as remark
            from dual) d
   where not exists (select 1
            from up_bank_mapping t
           where t.original_bank_code = d.original_bank_code
             and t.purpose_type = d.purpose_type);

--30
insert into up_bank_mapping
  (up_bank_mapping_oid,
   original_bank_code,
   destined_bank_code,
   purpose_type,
   bank_name,
   remark)
  select up_bank_mapping_SEQ.nextval as up_bank_mapping_oid,
         original_bank_code,
         destined_bank_code,
         purpose_type,
         bank_name,
         remark
    from (select '30' as original_bank_code,
                 '04025510' as destined_bank_code,
                 '1' as purpose_type,
                 '湖南农信' as bank_name,
                 '深圳、广州' as remark
            from dual) d
   where not exists (select 1
            from up_bank_mapping t
           where t.original_bank_code = d.original_bank_code
             and t.purpose_type = d.purpose_type);

--31
insert into up_bank_mapping
  (up_bank_mapping_oid,
   original_bank_code,
   destined_bank_code,
   purpose_type,
   bank_name,
   remark)
  select up_bank_mapping_SEQ.nextval as up_bank_mapping_oid,
         original_bank_code,
         destined_bank_code,
         purpose_type,
         bank_name,
         remark
    from (select '31' as original_bank_code,
                 '' as destined_bank_code,
                 '1' as purpose_type,
                 '福建农信' as bank_name,
                 '深圳、广州' as remark
            from dual) d
   where not exists (select 1
            from up_bank_mapping t
           where t.original_bank_code = d.original_bank_code
             and t.purpose_type = d.purpose_type);

--32
insert into up_bank_mapping
  (up_bank_mapping_oid,
   original_bank_code,
   destined_bank_code,
   purpose_type,
   bank_name,
   remark)
  select up_bank_mapping_SEQ.nextval as up_bank_mapping_oid,
         original_bank_code,
         destined_bank_code,
         purpose_type,
         bank_name,
         remark
    from (select '32' as original_bank_code,
                 '04024210' as destined_bank_code,
                 '1' as purpose_type,
                 '江西农信' as bank_name,
                 '深圳、广州' as remark
            from dual) d
   where not exists (select 1
            from up_bank_mapping t
           where t.original_bank_code = d.original_bank_code
             and t.purpose_type = d.purpose_type);
