-- 创建用户sa，密码：123456
create user 'sa'@'localhost' identified by '123456';
-- 赋权
GRANT ALL PRIVILEGES ON `LaundryManagementSystem`.* TO 'sa'@'localhost';


-- 创建数据库
create database LaundryManagementSystem;
use LaundryManagementSystem


-- 创建表
create table User(
	id int PRIMARY KEY AUTO_INCREMENT comment '用户唯一ID',
	name nvarchar(15) UNIQUE NOT NULL comment '用户名',
	password varchar(30) NOT NULL default '123456' comment '密码',
	level char(6) NOT NULL DEFAULT 'user' comment '用户级别' check(level in ('user','admin')),
	phone int,
	email nvarchar(50)
) comment '用户信息表';


-- 插入数据
insert into User(name,phone,email) values('abc','10086','abc@lms.com');
insert into User(name,password,phone,email) values('a','1','10010','a@lms.com');
insert into User(name,level,phone,email) values('admin','admin','120','admin@lms.com');
insert into User(name,password,level,phone,email) values('minda','1','admin','110','minda@lms.com');


-- 查看表结构
desc 表名;

-- 删除数据库
drop database 数据库名;

-- 删除数据表
drop table 表名;

-- 删除数据库用户
drop user 'sa'@'localhost';

-- 查询数据库用户
select user,host from mysql.user;
