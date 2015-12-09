# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

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

create sequence ticket_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists ticket;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists ticket_seq;

