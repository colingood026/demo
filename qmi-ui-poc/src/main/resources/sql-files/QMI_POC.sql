use master;
drop database QMI_POC;
create database QMI_POC;
use QMI_POC;

create table INV_ITEM(
REC_DATE datetime,	--收料日期
PUR_NO nvarchar(128),	--採購單號
MAT_01 nvarchar(128),	--基準料號
COL_NO nvarchar(128),	--色號
WID_TH nvarchar(128),	--幅寬
CNT_NO nvarchar(128),	--箱號
LOT_ID nvarchar(128),--缸號
LOC_CODE nvarchar(128),	--儲位
STOCK_QTY float,	--庫存量
UNT_RQ nvarchar(128)	--庫存單位
);

create table account(
account nvarchar(30),	--帳號
pswd nvarchar(15),	--密碼
favorite nvarchar(128)	--欄位順序紀錄
);

insert into INV_ITEM values 
(GETDATE(),'JKU0032H1','PR00614','Red',61.0,18,'D1','C1-10',44.6,'YDS'),
(GETDATE(),'JKU0032H1','PR00614','Navy',61.0,19,'D1','C1-10',52.6,'YDS'),
(GETDATE(),'JKU0032H1','PR00614','Green',61.0,19,'D1','C1-10',52.6,'YDS'),
(GETDATE(),'JKU0032J1','PR00614','Blue',61.0,19,'D1','C1-10',45,'YDS'),
(GETDATE(),'JKU0032J1','PR00614','Pink',61.0,19,'D1','C1-10',57,'YDS'),
(GETDATE(),'JKU0032J1','PR00614','Navy',61.0,19,'D1','C1-10',55.5,'YDS'),
(GETDATE(),'JKU0032K1','PR00652','Gray',45.0,19,'D1','C1-10',52.6,'YDS'),
(GETDATE(),'JKU0032K1','PR00656','Yellow',47.0,19,'D1','C1-10',53.5,'YDS'),
(GETDATE(),'JKU0032K1','PR00656','Red',47.0,19,'D1','C1-10',54.8,'YDS'),
(GETDATE(),'JKU0032K1','PR00657','Navy',65.0,19,'D1','C1-10',60.7,'YDS'),
(GETDATE(),'JKU0032L1','PR00657','Black',65.0,19,'D1','C1-10',63.3,'YDS'),
(GETDATE(),'JKU0032L1','PR00658','Navy',71.0,19,'D1','C1-10',45.9,'YDS'),
(GETDATE(),'JKU0032L1','PR00659','Navy',81.0,19,'D1','C1-10',123.1,'YDS');

insert into account (account,pswd) values
('Alex','A'),
('Bob','B'),
('Clark','C'),
('Dude','D')