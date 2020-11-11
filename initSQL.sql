-- 创建用户sa，密码：123456
create user 'sa'@'localhost' identified by '123456';
-- 赋权
GRANT ALL PRIVILEGES ON `StudentInfoManagement`.* TO 'sa'@'localhost';

-- 创建数据库
create database LaundryManagementSystem;
use LaundryManagementSystem

-- 创建表
create table User(

);
