# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table subject (
  id                            integer auto_increment not null,
  subject_name                  varchar(255),
  bango                         integer,
  constraint pk_subject primary key (id)
);

create table user_table (
  id                            integer auto_increment not null,
  login_id                      varchar(255),
  login_pw                      varchar(255),
  token                         varchar(255),
  insert_date                   datetime(6) not null,
  update_date                   datetime(6) not null,
  constraint pk_user_table primary key (id)
);


# --- !Downs

drop table if exists subject;

drop table if exists user_table;

