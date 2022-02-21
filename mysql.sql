CREATE DATABASE IF NOT EXISTS GirlFriend DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
use GirlFriend;

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

