CREATE DATABASE users;

CREATE TABLE users (
user_id serial primary key,
login character varying (2000) NOT NULL,
password character varying (2000) NOT NULL,
role_id INT REFERENCES role (role_id)
);

CREATE TABLE role (
role_id serial primary key,
role_name character varying (200)
);

CREATE TABLE role_rules (
role_id INT REFERENCES role(role_id),
rules_id INT REFERENCES rules(rule_id)
);

CREATE TABLE rules (
rule_id serial primary key,
role_rules CHARACTER VARYING (50),
);

--заявки
CREATE TABLE items (
id serial primary key,
description text,
user_id int references users(user_id),
category_id int references category(category_id),
sqlstate int references state(state_id)
--many to one
);

CREATE TABLE comments (
comments_id serial primary key,
description text,
item_id int references items(id)
);

CREATE TABLE attachs (
attach_id serial primary key,
attachs text,
item int references item(id),
);

create table category (
  category_id serial primary key,
  name_category varchar(2000)
);

create table state (
  state_id serial primary key,
  state varchar(2000)
);

insert into role (role_name) values ('user');
insert into role (role_name) values ('admin');

insert into users (login, password, role_id) values ('user1', 'password', 1);
insert into users (login, password, role_id) values ('user2', 'password', 2);
