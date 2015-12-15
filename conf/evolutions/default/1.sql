# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table comment (
  id                        bigint not null,
  comment_desc              varchar(255),
  status                    varchar(255),
  ticket_id                 bigint,
  user_id                   bigint,
  constraint pk_comment primary key (id))
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
  user_id                   bigint,
  constraint pk_ticket primary key (id))
;

create table user (
  id                        bigint not null,
  email                     varchar(255),
  first_name                varchar(255),
  last_name                 varchar(255),
  phone                     varchar(255),
  dept                      varchar(255),
  password                  varchar(255),
  company                   varchar(255),
  admin                     varchar(255),
  constraint pk_user primary key (id))
;

create table user_access (
  id                        bigint not null,
  can_add                   boolean,
  can_read                  boolean,
  can_update                boolean,
  can_delete                boolean,
  user_id                   bigint,
  constraint pk_user_access primary key (id))
;

create sequence comment_seq;

create sequence ticket_seq;

create sequence user_seq;

create sequence user_access_seq;

alter table comment add constraint fk_comment_ticket_1 foreign key (ticket_id) references ticket (id) on delete restrict on update restrict;
create index ix_comment_ticket_1 on comment (ticket_id);
alter table comment add constraint fk_comment_user_2 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_comment_user_2 on comment (user_id);
alter table ticket add constraint fk_ticket_user_3 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_ticket_user_3 on ticket (user_id);
alter table user_access add constraint fk_user_access_user_4 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_user_access_user_4 on user_access (user_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists comment;

drop table if exists ticket;

drop table if exists user;

drop table if exists user_access;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists comment_seq;

drop sequence if exists ticket_seq;

drop sequence if exists user_seq;

drop sequence if exists user_access_seq;

