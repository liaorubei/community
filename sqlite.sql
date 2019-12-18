create table Question(
  Id varchar(32),
  Title varchar(256),
  Description TEXT,
  CreateBy TEXT,
  CreateAt TEXT,
  ModifyAt TEXT,
  CommentCount INTEGER,
  ViewCount INTEGER,
  LikeCount INTEGER,
  Tag varchar(256),
  constraint PK_Question PRIMARY KEY (Id)
);