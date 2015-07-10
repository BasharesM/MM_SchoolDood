drop database if exists school_doodle;

create database school_doodle;

use school_doodle;

create table users (
       uid int(4) auto_increment not null,
       first_name varchar(255) not null,
       last_name varchar(255),
       email varchar(255) not null,
       password varchar(40) not null,
       primary key(uid)
);

create table doodles (
       did int(4) auto_increment not null,
       uid int(4) not null,
       title varchar(255) not null,
       question varchar(255) not null,
       status int(1) default 1 not null,
       primary key(did),
       foreign key(uid) references users(uid)
);

create table doodle_emails (
       eid int(4) auto_increment not null,
       uid int(4) not null,
       email varchar(255) not null,
       primary key(eid),
       foreign key(uid) references users(uid)
);

create table answers (
       aid int(4) auto_increment not null,
       label varchar(255) not null,
       primary key (aid)
);

create table user_doodles(
       eid int(4) not null,
       did int(4) not null,
       aid int(4) not null,
       primary key(eid, did, aid),
       foreign key (eid) references doodle_emails(eid),
       foreign key (did) references doodles(did),
       foreign key (aid) references answers(aid)
);

insert into users (first_name, last_name, email, password) values
       ('Matt', 'Kelvin', 'blabla@gmail.com', '45c8586a626ddabd233951066138d0efa7f4eb9d'),
       ('Mich', 'Baba', 'patatra@gmail.com', '45c8586a626ddabd233951066138d0efa7f4eb9d');

insert into answers (label) values
       ('non'),
       ('oui'),
       ('peut-être');
