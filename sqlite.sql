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

insert into Goods(id, title, price, istop, url, image, thumb) values ('11','女子防身用品防身手电筒女生随身便携防狼神器尖叫报警器女防狼器女子自卫用品',99.99,0,'https://item.m.jd.com/product/10021624770759.html',null,1);
insert into Goods(id, title, price, istop, url, image, thumb) values ('12','【5米远射 可过安检】防狼神器男女生户外防身用品催泪剂洒水剂安防爆自卫喷射洒雾女性随身剂安防保安辣椒 6瓶268质保三年免费换新',99.99,0,'https://item.m.jd.com/product/10030814087245.html',null,1);
insert into Goods(id, title, price, istop, url, image, thumb) values ('13','【5米远射一秒见效】防狼神器防卫女士用品防护户外喷洒雾女生安全随身剂非辣素 110毫升 效果强劲【免费试用 三年换新】',99.99,0,'https://item.m.jd.com/product/10021624770759.html',null,1);
insert into Goods(id, title, price, istop, url, image, thumb) values ('14','防狼神器防卫女士用品防护户外喷洒雾',99.99,0,'https://item.m.jd.com/product/10021624770759.html',null,1);
insert into Goods(id, title, price, istop, url, image, thumb) values ('15','110毫升 效果强劲',99.99,0,'https://item.m.jd.com/product/10021624770759.html',null,1);
insert into Goods(id, title, price, istop, url, image, thumb) values ('16','尖叫报警器女防狼器女子自卫用品',99.99,0,'https://item.m.jd.com/product/10021624770759.html',null,1);

insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('81','够了，别动不动就骂她堕落','description',1,'https://mp.weixin.qq.com/s/RPyqZCeTi7mRpIgJgrJ1Ug',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('82','有人在为西安地铁女孩发声，有人在求她的高清无码视频','description',1,'https://mp.weixin.qq.com/s/oDl98MGFEXn6Kfo1e11KTQ',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('83','“主动吃避孕药就是不自爱？”别再随便骂这颗小药丸了！| 女性安全指南183','description',1,'https://mp.weixin.qq.com/s/FEBesp6V_rUAjyaUGNsgwQ',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('84','麻醉阴道，献祭初夜，女孩的「第一次」需要这么拼吗？ | 女性安全指南181','description',1,'https://mp.weixin.qq.com/s/FW_mDUKyxaPCnPO-WdGLXA',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('85','你以为的时尚街拍，其实都是付费小片','description',1,'https://mp.weixin.qq.com/s/8EWqYSIn-RGuUTmxKUwufA',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('86','“200斤的肥肉面前，再厉害的简历也成了废纸”｜5XL女孩的自白','description',1,'https://mp.weixin.qq.com/s/rM8vvv_EZ9BKrG14BgXRzw',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('87','上不去热搜的「她」，可以被你拯救','description',1,'https://mp.weixin.qq.com/s/7viGzKgyg1xD3utx4hOzug',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('88','她驱船乘风破浪，只为了帮女人们堕胎','description',1,'https://mp.weixin.qq.com/s/320lqZWB24sFaihPgIRXJQ',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('89','她驱船乘风破浪，只为了帮女人们堕胎','description',1,'https://mp.weixin.qq.com/s/320lqZWB24sFaihPgIRXJQ',0,0,0);

insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('91','这些针对女性的暴力，还在被轻视','description',1,'https://mp.weixin.qq.com/s/oDl98MGFEXn6Kfo1e11KTQ',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('92','月经提前和月经推迟，哪个对身体更不好？','description',1,'https://mp.weixin.qq.com/s/G7vALXUS96I-o-41ibsP2A',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('93','子宫生病的4个信号，很多女生都没当回事','description',1,'https://mp.weixin.qq.com/s/mNAnXYAu7aqaf4Hviu_mKg',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('94','月经来两三天就走是卵巢早衰吗？医生告诉你答案','description',1,'https://mp.weixin.qq.com/s/oJh96NWavsBbUQaJZd5L4A',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('95','女性痛经全过程曝光！出现这4个现象，及时看医生','description',1,'https://mp.weixin.qq.com/s/g4VBvxD2EfjGxMHCpPZtow',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('96','如何跟孩子谈“性”，这2个高中生做了最好的示范','description',1,'https://mp.weixin.qq.com/s/2cJFHoCt8b3kRrgfGgTJ2A',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('97','90%人都没听说过HPV，每年却有三万女性因此丧命 | 女孩别怕024','description',1,'https://mp.weixin.qq.com/s/-yYtTFqCpF1vfemAy_h1VQ',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('98','“总感觉我们的关系如履薄冰”面对恋爱中的冷暴力，我该怎么办？ | 女孩别怕049','description',1,'https://mp.weixin.qq.com/s/cp6xK2-yfu1GlCQFV3aS_w',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('99','我跟女警聊了聊，单身女孩在外租房如何判断附近安不安全 | 女孩别怕002','description',1,'https://mp.weixin.qq.com/s/v8pd_B7hJ03NRJEG4xYs0g',0,0,0);
insert into Article(id, title, description, isoriginal, url, commentcount, viewcount, likecount) values ('100','「她一心救人，却被骂姿势不雅。」网络暴力究竟有多可怕｜女孩别怕081','description',1,'https://mp.weixin.qq.com/s/TXxTclMcQh_E6ZTgU5fXYw',0,0,0);

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