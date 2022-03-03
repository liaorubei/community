CREATE DATABASE IF NOT EXISTS GirlFriend DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
use GirlFriend;

drop table if exists SysUser;
create table SysUser
(
    Id       varchar(32) not null,
    Username varchar(32),
    Password varchar(32),
    Nickname varchar(32),
    Realname varchar(32),
    Avatar   varchar(128),
    CONSTRAINT PK_SysUser primary key (Id)
);

drop table if exists User;
create table User
(
    Id       varchar(32) not null,
    Username varchar(32),
    Password varchar(32),
    Nickname varchar(32),
    Realname varchar(32),
    Avatar   varchar(128),
    CONSTRAINT PK_User primary key (Id)
);

drop table if exists Groups;
create table Groups
(
    Id          varchar(32) not null,
    Title       varchar(64),
    Description varchar(512),
    Leader      varchar(32),
    CreateBy    varchar(32),
    CreateAt    varchar(32),
    Avatar      varchar(128),
    CONSTRAINT Pk_Groups primary key (Id)
);

drop table if exists GroupsUser;
create table GroupsUser
(
    GroupId varchar(32) not null,
    UserId  varchar(32) not null,
    CONSTRAINT Pk_GroupsUser primary key (GroupId, UserId)
);

drop table if exists Article;
create table Article
(
    Id           varchar(32) not null,
    Title        varchar(128),
    Content      varchar(4096),
    Description  varchar(2048),
    IsOriginal   INTEGER,
    Type         INTEGER,
    Url          varchar(256),
    CreateBy     varchar(32),
    CreateAt     varchar(32),
    ModifyAt     varchar(32),
    CommentCount INTEGER,
    ViewCount    INTEGER,
    LikeCount    INTEGER,
    Tag          varchar(256),
    GroupId      varchar(32),
    CONSTRAINT PK_Article PRIMARY KEY (Id)
);

drop table if exists Comment;
create table Comment
(
    Id         INTEGER primary key AUTO_INCREMENT not null,
    Content    varchar(256),
    QuestionId varchar(32),
    ParentId   INTEGER,
    CreateBy   varchar(32),
    CreateAt   DATETIME,
    ModifyAt   DATETIME,
    LikeCount  INTEGER
-- ,    constraint Pk_Comment primary key (Id)
);

drop table if exists Goods;
create table Goods
(
    Id    varchar(32) not null,
    Title varchar(128),
    Price DOUBLE,
    IsTop INTEGER,
    Url   varchar(256),
    Image varchar(256),
    Thumb INTEGER,
    CONSTRAINT Pk_Goods primary key (Id)
);

drop table if exists Apk;
create table Apk
(
    Id          varchar(32)    not null,
    CreateAt    DATETIME    not null,
    VersionCode INTEGER not null,
    VersionName varchar(32),
    Path        varchar(256)    not null,
    IsRelease   INTEGER,
    constraint Pk_Apk primary key (Id)
);

insert into Apk(id, createat, versioncode, versionname, path, isrelease) VALUES ('01','2020-12-12 12:12:12',1,'1','/apks/1.apk',1);
insert into Apk(id, createat, versioncode, versionname, path, isrelease) VALUES ('02','2020-12-12 12:12:12',2,'1','/apks/1.apk',1);
insert into Apk(id, createat, versioncode, versionname, path, isrelease) VALUES ('03','2020-12-12 12:12:12',3,'1','/apks/1.apk',1);
insert into Apk(id, createat, versioncode, versionname, path, isrelease) VALUES ('04','2020-12-12 12:12:12',4,'1','/apks/1.apk',1);
insert into Apk(id, createat, versioncode, versionname, path, isrelease) VALUES ('05','2020-12-12 12:12:12',5,'1','/apks/1.apk',1);
