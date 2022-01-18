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
create table Goods(
    Id TEXT,
    Title TEXT,
    Price REAL,
    IsTop INTEGER ,
    Url TEXT,
    Image TEXT,
    Thumb INTEGER
);