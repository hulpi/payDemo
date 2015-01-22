
comment on table up_transaction is
'待支付数据信息表';

comment on column up_transaction.up_sys_register_oid is
'系统OID';

comment on column up_transaction.uf_app_ledg_seq_id is
'业务支付ID';

comment on column up_transaction.uf_send_batch_id is
'业务发送批次';

comment on column up_transaction.uf_app_code is
'申请人ID';

comment on column up_transaction.uf_city_code is
'城市ID';

comment on column up_transaction.up_agent_pay_oid is
'代理收付方OID';

comment on column up_transaction.pay_type is
'支付类型';

comment on column up_transaction.up_merchant_oid is
'商户Oid';

comment on column up_transaction.reference_no is
'业务参考号';

comment on column up_transaction.account_no is
'收付方帐号';

comment on column up_transaction.account_name is
'收付方户名';

comment on column up_transaction.bank_code is
'收付方银行ID';

comment on column up_transaction.bank_name is
'收付方银行名称';

comment on column up_transaction.bank_province is
'收付方开户省';

comment on column up_transaction.bank_city is
'收付方开户市';

comment on column up_transaction.settle_type is
'结算方式';

comment on column up_transaction.amount is
'交易金额';

comment on column up_transaction.currency is
'币种';

comment on column up_transaction.expect_settle_date is
'预期结算时间';

comment on column up_transaction.actual_settle_date is
'实际结算时间';

comment on column up_transaction.status is
'处理状态: 
1 已审核
2 数据不合法
3 需要重新发送
4  已传输
5  传输成功
6  传输失败
7  交易成功
8  失败交易';

comment on column up_transaction.version_no is
'版本ID';

comment on column up_transaction.remark is
'备注, 用于 status = 2 时， 填写相关的错误信息';

comment on column up_transaction.create_date is
'创建日期';