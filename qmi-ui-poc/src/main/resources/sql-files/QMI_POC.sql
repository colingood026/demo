use master;
drop database QMI_POC;
create database QMI_POC;
use QMI_POC;

create table INV_ITEM(
REC_DATE datetime,	--���Ƥ��
PUR_NO nvarchar(128),	--���ʳ渹
MAT_01 nvarchar(128),	--��ǮƸ�
COL_NO nvarchar(128),	--�⸹
WID_TH nvarchar(128),	--�T�e
CNT_NO nvarchar(128),	--�c��
LOT_ID nvarchar(128),--����
LOC_CODE nvarchar(128),	--�x��
STOCK_QTY float,	--�w�s�q
UNT_RQ nvarchar(128)	--�w�s���
);

create table account(
account nvarchar(30),	--�b��
pswd nvarchar(15),	--�K�X
favorite nvarchar(128)	--��춶�Ǭ���
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