
comment on table up_merchant is
'商户信息表

根据 city_code 来获取 merchant 对象';

comment on column up_merchant.merchant_code is
'商户代码';

comment on column up_merchant.city_code is
'城市ID';

comment on column up_merchant.city_name is
'城市名称';

comment on column up_merchant.account_no is
'帐号';

comment on column up_merchant.account_name is
'户名';

comment on column up_merchant.bank_code is
'银行ID';

comment on column up_merchant.bank_name is
'银行名称';

comment on column up_merchant.bank_province is
'开户省';

comment on column up_merchant.bank_city is
'开户市';

comment on column up_merchant.remark is
'备注';
