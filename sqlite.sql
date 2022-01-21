-- noinspection SqlNoDataSourceInspectionForFile

NULL	值是一个 NULL 值。
INTEGER	值是一个带符号的整数，根据值的大小存储在 1、2、3、4、6 或 8 字节中。
REAL	值是一个浮点值，存储为 8 字节的 IEEE 浮点数字。
TEXT	值是一个文本字符串，使用数据库编码（UTF-8、UTF-16BE 或 UTF-16LE）存储。
BLOB	值是一个 blob 数据，完全根据它的输入存储。

create table User
(
  Id       varchar(32),
  Username varchar(256),
  Password varchar(256),
  Nickname varchar(256),
  Realname varchar(256),
  Avatar   varchar(256),
  CONSTRAINT PK_User primary key (Id)
);

drop table if exists Groups;
create table Groups
(
    Id          TEXT,
    Title       TEXT,
    Description TEXT,
    Leader      TEXT,
    CreateBy    TEXT,
    CreateAt    TEXT,
    Avatar      TEXT,
    CONSTRAINT Pk_Groups primary key (Id)
);

drop table if exists GroupsUser;
create table GroupsUser
(
    GroupId TEXT,
    UserId   TEXT,
    CONSTRAINT Pk_GroupsUser primary key (GroupId, UserId)
);

drop table if exists Article;
create table Article
(
    Id           TEXT,
    Title        TEXT,
    Content TEXT,
    Description  TEXT,
    IsOriginal   INTEGER,
    Type         INTEGER ,
    Url          TEXT,
    CreateBy     TEXT,
    CreateAt     TEXT,
    ModifyAt     TEXT,
    CommentCount INTEGER,
    ViewCount    INTEGER,
    LikeCount    INTEGER,
    Tag          varchar(256),
    GroupId TEXT,
    CONSTRAINT PK_Question PRIMARY KEY (Id)
);

insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('1','title1','description',1,'http://www.baidu.com',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('2','title2','description',1,'http://www.baidu.com',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('3','title3','description',1,'http://www.baidu.com',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('4','title4','description',1,'http://www.baidu.com',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('5','title5','description',1,'http://www.baidu.com',0,0,0);

create table Question
(
  Id           varchar(32),
  Title        varchar(256),
  Description  TEXT,
  CreateBy     TEXT,
  CreateAt     TEXT,
  ModifyAt     TEXT,
  CommentCount INTEGER,
  ViewCount    INTEGER,
  LikeCount    INTEGER,
  Tag          varchar(256),
  CONSTRAINT PK_Question PRIMARY KEY (Id)
);

drop table if exists Comment;
create table Comment
(
  Id         INTEGER PRIMARY KEY AUTOINCREMENT,
  Content    VARCHAR(1024),
  QuestionId VARCHAR(32),
  ParentId   INTEGER,
  CreateBy   VARCHAR(32),
  CreateAt   DATETIME,
  ModifyAt   DATETIME,
  LikeCount  INTEGER
);

drop table if exists Goods;
create table Goods
(
    Id    TEXT,
    Title TEXT,
    Price REAL,
    IsTop INTEGER,
    Url   TEXT,
    Image TEXT,
    Thumb INTEGER,
    CONSTRAINT Pk_Goods primary key (Id)
);
insert into Goods(Id,Title,Price,IsTop,Url,Image,Thumb) values('1','防狼喷雾剂1',99.99,1,'http:www.baidu.com','/images/logo.png',1);
insert into Goods(Id,Title,Price,IsTop,Url,Image,Thumb) values('2','防狼喷雾剂2号',99.99,1,'http:www.baidu.com','/images/logo.png',1);
insert into Goods(Id,Title,Price,IsTop,Url,Image,Thumb) values('3','防狼喷雾剂-粉色',99.99,1,'http:www.baidu.com','/images/logo.png',1);
insert into Goods(Id,Title,Price,IsTop,Url,Image,Thumb) values('4','防狼喷雾剂-红色',99.99,1,'http:www.baidu.com','/images/logo.png',1);
insert into Goods(Id,Title,Price,IsTop,Url,Image,Thumb) values('5','防狼喷雾剂-蓝色',99.99,1,'http:www.baidu.com','/images/logo.png',1);
insert into Goods(Id,Title,Price,IsTop,Url,Image,Thumb) values('6','防狼喷雾剂-黄色',99.99,1,'http:www.baidu.com','/images/logo.png',1);