create table Spitter (
                         id integer auto_increment primary key ,
                         username varchar(20) unique not null,
                         password varchar(20) not null,
                         first_name varchar(30) not null,
                         last_name varchar(30) not null,
                         email varchar(30) not null
);
create table spittle (
                         id integer auto_increment primary key,
                         spitter integer not null,
                         message varchar(2000) not null,
                         postedTime datetime not null,
                         foreign key (spitter) references spitter(id)
);

create table Manager
(
    id        integer auto_increment primary key,
    username  varchar(20) unique not null,
    password  varchar(20)        not null,
    full_name varchar(60)        not null,
    email     varchar(30)        not null,
    phoneNo   varchar(30)        not null,
    delete    integer            not null
);

insert into Manager
values ( 1,'admin','admin','Luo Xinyu','852559563@qq.com','13808036096',0);