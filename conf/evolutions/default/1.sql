# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table ticket_model (
  id                        bigint not null,
  title                     varchar(255),
  desc                      varchar(255),
  severity                  varchar(255),
  owner                     varchar(255),
  responsible               varchar(255),
  status                    varchar(255),
  date                      timestamp,
  constraint pk_ticket_model primary key (id))
;

create sequence ticket_model_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists ticket_model;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists ticket_model_seq;

