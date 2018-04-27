SET FOREIGN_KEY_CHECKS=0;

drop table if exists reports;

drop table if exists users;

drop table if exists users_reports;

drop table if exists confs;

drop table if exists roles;

SET FOREIGN_KEY_CHECKS=1;
/*==============================================================*/
/* Table: confs                                                 */
/*==============================================================*/
create table confs
(
  conf_id              int not null,
  conf_name            varchar(44) not null,
  conf_place           varchar(44) not null,
  conf_date            timestamp not null,
  primary key (conf_id)
);

/*==============================================================*/
/* Table: reports                                               */
/*==============================================================*/
create table reports
(
  report_id            int not null,
  conf_id              int not null,
  report_name          varchar(22) not null,
  report_desk          varchar(255) not null,
  is_offered           bool DEFAULT FALSE ,
  primary key (report_id)
);

/*==============================================================*/
/* Table: roles                                                 */
/*==============================================================*/
create table roles
(
  role_id              int not null,
  role_name            varchar(22) not null,
  primary key (role_id)
);

/*==============================================================*/
/* Table: users                                                 */
/*==============================================================*/
create table users
(
  user_id              int not null,
  role_id              int not null,
  email                varchar(44) not null,
  password             varchar(44) not null,
  rating               int DEFAULT 0,
  primary key (user_id)
);

/*==============================================================*/
/* Table: users_reports                                         */
/*==============================================================*/
create table users_reports
(
  report_id            int not null,
  user_id              int not null,
  active_speaker       bool DEFAULT FALSE ,
  primary key (report_id, user_id)
);

alter table reports add constraint FK_Relationship_2 foreign key (conf_id)
references confs (conf_id) on delete restrict on update restrict;

alter table users add constraint FK_Relationship_1 foreign key (role_id)
references roles (role_id) on delete restrict on update restrict;

alter table users_reports add constraint FK_Relationship_3 foreign key (report_id)
references reports (report_id) on delete restrict on update restrict;

alter table users_reports add constraint FK_Relationship_4 foreign key (user_id)
references users (user_id) on delete restrict on update restrict;

