-- 创建用户sa，密码：123456
create user 'sa'@'localhost' identified by '123456';
-- 赋权
GRANT ALL PRIVILEGES ON `LaundryManagementSystem`.* TO 'sa'@'localhost';


-- 创建数据库
create database LaundryManagementSystem;
use LaundryManagementSystem


-- 创建表
create table User(
	ID int PRIMARY KEY AUTO_INCREMENT comment '用户唯一ID',
	name nvarchar(15) UNIQUE NOT NULL comment '用户名',
	password nvarchar(30) NOT NULL default '123456' comment '密码',
	level char(6) NOT NULL DEFAULT 'user' comment '用户级别或类型' check(level in ('user','admin')),
	tel varchar(15) comment '联系电话'
) CHARSET=utf8 comment '用户信息表';

create table Washer(
	ID INT PRIMARY KEY AUTO_INCREMENT comment '洗衣机唯一ID',
	status nchar(5) NOT NULL default '未使用' comment '洗衣机使用状态' check(status in('使用中','未使用'))
) CHARSET=utf8 comment '洗衣机信息表';

create table Price(
	Mode NCHAR(10) PRIMARY KEY COMMENT '洗衣价目表',
	Price FLOAT(6,2) NOT NULL COMMENT '洗衣价格',
	Duration INT NOT NULL COMMENT '洗衣时长（以分钟计）'
) CHARSET=utf8 comment '洗衣价目表';

create table `Order`(
	ID INT PRIMARY KEY AUTO_INCREMENT comment '订单唯一ID',
	UserID INT NOT NULL comment '用户ID',
	WasherID INT NOT NULL comment '洗衣机ID',
	Mode NCHAR(10) NOT NULL comment '洗衣模式',
	GeneratedTime DATE NOT NULL comment '订单生成时间',
	FOREIGN KEY(UserID) REFERENCES User(ID),
	FOREIGN KEY(WasherID) REFERENCES Washer(ID),
	FOREIGN KEY(Mode) REFERENCES Price(Mode)
) CHARSET=utf8 comment '订单信息表';


-- 插入数据
insert into User(name,tel) values('abc','10086');
insert into User(name,password,tel) values('a','1','10010');
insert into User(name,level,tel) values('admin','admin','120');
insert into User(name,password,level,tel) values('minda','1','admin','110');

insert into Washer values();
insert into Washer values();
insert into Washer values();
insert into Washer values();
insert into Washer values();
insert into Washer values();
insert into Washer values();
insert into Washer values();
insert into Washer values();
insert into Washer values();
insert into Washer values();
insert into Washer values();
insert into Washer values();
insert into Washer values();
insert into Washer values();
insert into Washer values();
insert into Washer values();
insert into Washer values();
insert into Washer values();
insert into Washer values();
insert into Washer values();
insert into Washer values();
insert into Washer values();
insert into Washer values();

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
