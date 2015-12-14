# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table access (
  id                        bigint not null,
  can_add                   boolean,
  can_read                  boolean,
  can_update                boolean,
  can_delete                boolean,
  user_id                   bigint,
  constraint pk_access primary key (id))
;

create table comment (
  comment_id                bigint not null,
  comment_desc              varchar(255),
  status                    varchar(255),
  id                        bigint,
  constraint pk_comment primary key (comment_id))
;

create table ticket (
  id                        bigint not null,
  title                     varchar(255),
  desc                      varchar(255),
  severity                  varchar(255),
  owner                     varchar(255),
  responsible               varchar(255),
  status                    varchar(255),
  date                      varchar(255),
  constraint pk_ticket primary key (id))
;

create table user (
  email                     varchar(255) not null,
  first_name                varchar(255),
  last_name                 varchar(255),
  phone                     varchar(255),
  dept                      varchar(255),
  password                  varchar(255),
  company                   varchar(255),
  admin                     varchar(255),
  constraint pk_user primary key (email))
;

create sequence access_seq;

create sequence comment_seq;

create sequence ticket_seq;

create sequence user_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists access;

drop table if exists comment;

drop table if exists ticket;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists access_seq;

drop sequence if exists comment_seq;

drop sequence if exists ticket_seq;

drop sequence if exists user_seq;

