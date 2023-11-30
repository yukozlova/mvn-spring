drop schema if exists db_test;

create schema if not exists db_test;

use db_test;

create table if not exists cash_card (
    id int auto_increment primary key,
    amount numeric(10,2) not null default 0
);

create table if not exists account (
    id int auto_increment primary key,
    amount numeric(10, 4) not null default 0
);

create table if not exists transfer (
    id int auto_increment primary key,
    account_from int not null,
    account_to int not null,
    tr_date timestamp not null,
    foreign key (account_from) references account(id),
    foreign key (account_to) references account(id)
);