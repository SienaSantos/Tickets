# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table comment (
  comment_id                bigint not null auto_increment,
  comment_desc              varchar(255),
  id_id                     bigint,
  constraint pk_comment primary key (comment_id))
;

create table ticket (
  id                        bigint not null auto_increment,
  title                     varchar(255),
  desc                      varchar(255),
  severity                  varchar(255),
  owner                     varchar(255),
  responsible               varchar(255),
  status                    varchar(255),
  date                      varchar(255),
  constraint pk_ticket primary key (id))
;

create sequence comment_seq;

create sequence ticket_seq;

alter table comment add constraint fk_comment_id_1 foreign key (id_id) references ticket (id) on delete restrict on update restrict;
create index ix_comment_id_1 on comment (id_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists comment;

drop table if exists ticket;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists comment_seq;

drop sequence if exists ticket_seq;
