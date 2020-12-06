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
	name nvarchar(30) comment '洗衣机名称',
	location nvarchar(50) comment '洗衣机位置'
) CHARSET=utf8 comment '洗衣机信息表';

create table Price(
	Mode NCHAR(10) PRIMARY KEY COMMENT '洗衣价目表',
	Price FLOAT(6,2) NOT NULL COMMENT '洗衣价格',
	Duration INT NOT NULL COMMENT '洗衣时长（以分钟计）'
) CHARSET=utf8 comment '洗衣价目表';

create table `Order`(
	ID INT PRIMARY KEY AUTO_INCREMENT comment '订单唯一ID',
	UserID INT NOT NULL comment '用户ID',
	WasherID INT NOT NULL UNIQUE comment '洗衣机ID',
	Mode NCHAR(10) NOT NULL comment '洗衣模式',
	GeneratedTime DATETIME NOT NULL comment '订单生成时间',
	FOREIGN KEY(UserID) REFERENCES User(ID) ON DELETE CASCADE,
	FOREIGN KEY(WasherID) REFERENCES Washer(ID) ON DELETE CASCADE,
	FOREIGN KEY(Mode) REFERENCES Price(Mode) ON DELETE CASCADE
) CHARSET=utf8 comment '订单信息表';


-- 插入数据
insert into User(name,tel) values('abc','10086');
insert into User(name,password,tel) values('a','1','10010');
insert into User(name,level,tel) values('admin','admin','120');
insert into User(name,password,level,tel) values('minda','1','admin','110');

insert into Washer(name,location) values('1号洗衣机','1号宿舍楼第1层');
insert into Washer(name,location) values('2号洗衣机','1号宿舍楼第1层');
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

insert into `Price`(Mode,Price,Duration) values("标准洗","4","40");
insert into `Price`(Mode,Price,Duration) values("快洗","3","20");
insert into `Price`(Mode,Price,Duration) values("单脱水","1","5");

insert into `Order`(UserID,WasherID,Mode,GeneratedTime) values(3,6,"标准洗","2020-12-03");


-- 分页查询所有洗衣机和对应的使用者并升序排序
select ID,name,location,UserID from (
	select Washer.ID,name,location,UserID from Washer 
	left outer join `Order` on Washer.ID=`Order`.washerID
)temp order by ID asc limit 1,5;
		
-- 分页查询所有闲置洗衣机和正在被UserID使用的洗衣机
select ID,name,location,UserID from (
	select Washer.ID,name,location,UserID from Washer 
	left outer join `Order` on Washer.ID=`Order`.washerID
)temp where UserID is null or UserID='' or UserID=3 order by ID asc limit 0,10;


	
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
