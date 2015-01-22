
comment on table up_bank_mapping is
'银行代码对应表

purpose_type = 1
用于通联的银行代码';

comment on column up_bank_mapping.original_bank_code is
'原业务系统的银行代码';

comment on column up_bank_mapping.destined_bank_code is
'收付代理方的银行代码';

comment on column up_bank_mapping.purpose_type is
'1-用于通联支付
2-招商银行
3-银联支付';

comment on column up_bank_mapping.bank_name is
'银行名称';

comment on column up_bank_mapping.remark is
'备注';
