SET FOREIGN_KEY_CHECKS=0;

drop table if exists confs;

drop table if exists reports;

drop table if exists roles;

drop table if exists users;

drop table if exists users_reports;
SET FOREIGN_KEY_CHECKS=1;

create table confs
(
  conf_id              int not null,
  conf_name            varchar(44) not null,
  conf_place           varchar(44) not null,
  conf_date            timestamp not null,
  primary key (conf_id)
);

create table reports
(
  report_id            int not null,
  conf_id              int not null,
  report_name          varchar(22) not null,
  report_desk          varchar(255) not null,
  primary key (report_id)
);

create table roles
(
  role_id              int not null,
  role_name            varchar(22) not null,
  primary key (role_id)
);

create table users
(
  user_id              int not null,
  role_id              int not null,
  email                varchar(44) not null,
  password             varchar(44) not null,
  rating               int DEFAULT 0,
  primary key (user_id)
);

create table users_reports
(
  user_id              int not null,
  report_id            int not null,
  active_speaker       bool DEFAULT TRUE ,
  by_speaker           bool DEFAULT FALSE,
  by_moder             bool DEFAULT FALSE,
  confirmed            bool DEFAULT TRUE ,
  primary key (user_id, report_id)
);

alter table reports add constraint FK_Relationship_2 foreign key (conf_id)
references confs (conf_id) on delete restrict on update restrict;

alter table users add constraint FK_Relationship_1 foreign key (role_id)
references roles (role_id) on delete restrict on update restrict;

alter table users_reports add constraint FK_Relationship_4 foreign key (user_id)
references users (user_id) on delete restrict on update restrict;

alter table users_reports add constraint FK_Relationship_5 foreign key (report_id)
references reports (report_id) on delete restrict on update restrict;

