-- 创建用户sa，密码：123456
create user 'sa'@'localhost' identified by '123456';
-- 赋权
GRANT ALL PRIVILEGES ON `LaundryManagementSystem`.* TO 'sa'@'localhost';


-- 创建数据库
create database LaundryManagementSystem;
use LaundryManagementSystem

-- 创建表
create table User(
	name nvarchar(15) NOT NULL comment '用户名',
	id int primary key AUTO_INCREMENT comment '用户唯一ID',
	password varchar(30) NOT NULL default '123456' comment '密码',
	phone int,
	email nvarchar(20)
) comment '用户信息表';

create table Admin(
	name nvarchar(15) not null comment '用户名',
	id int primary key auto_increment comment '用户唯一id',
	password varchar(30) not null default 'abcdefg' comment '密码',
	phone int,
	email nvarchar(20)
) comment '管理员信息表';


-- 插入数据
insert into User(name,phone,email) values('abc','10086','abc@hyit.com');
insert into User(name,password,phone,email) values('a','1','10086','abc@hyit.com');

insert into Admin(name,phone,email) values('admin','10086','abc@hyit.com');
insert into Admin(name,password,phone,email) values('a','1','10086','abc@hyit.com');


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
