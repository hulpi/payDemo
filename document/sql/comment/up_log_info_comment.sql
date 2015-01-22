comment on table up_log_info is
'日志记录信息表';

comment on column up_log_info.type is
'类型：
1 用户操作日志
2 系统Job日志
3 异常日志';

comment on column up_log_info.content is
'日志内容';

comment on column up_log_info.creator is
'操作用户';

comment on column up_log_info.create_date is
'创建时间';