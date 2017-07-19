# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table subject (
  id                            integer,
  bango                         integer
);

create table subject_name (
  id                            integer auto_increment not null,
  subject_name                  varchar(255),
  constraint pk_subject_name primary key (id)
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

alter table subject add constraint fk_subject_id foreign key (id) references subject_name (id) on delete restrict on update restrict;
create index ix_subject_id on subject (id);


# --- !Downs

alter table subject drop foreign key fk_subject_id;
drop index ix_subject_id on subject;

drop table if exists subject;

drop table if exists subject_name;

drop table if exists user_table;

