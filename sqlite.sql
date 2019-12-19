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