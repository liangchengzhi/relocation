select * from record where id = 5812;
select * from record_transitionfee where sid = 5812;

update record set last_compute_time = null where id = 5812;
delete from record_transitionfee where sid = 5812;

delete from record_transitionfee;
delete from record_return;
delete from record;
delete from project;
delete from user_operate_log;