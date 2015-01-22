comment on table up_batch_process is
'交易批次信息表';

comment on column up_batch_process.file_path is
'文件路径';

comment on column up_batch_process.total_item is
'总记录数';

comment on column up_batch_process.total_sum is
'总金额';

comment on column up_batch_process.req_sn is
'交易批次号';

comment on column up_batch_process.return_code is
'返回代码';

comment on column up_batch_process.status is
'处理状态:
1  已发送报文 
2  发送响应成功
3  发送响应失败
4  查询成功';

comment on column up_batch_process.error_msg is
'错误消息';

comment on column up_batch_process.create_date is
'创建日期';
