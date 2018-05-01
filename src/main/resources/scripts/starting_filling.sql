INSERT INTO roles (role_id, role_name) VALUES (1,'admin'), (2,'moder'), (3,'speaker'), (4,'plain_user');
INSERT INTO users (user_id, role_id, email, password) VALUES (777,1,'root','root');
INSERT INTO confs (conf_id, conf_name, conf_place,conf_date) VALUES(1,'Kiev Java Epam Open', 'Kiev, Kudryashova', 180518);
INSERT INTO reports (report_id, conf_id, report_name, report_desk) VALUES (1,1,'Java Fx', 'Report about Java FX posiibilities');
INSERT INTO reports (report_id, conf_id, report_name, report_desk) VALUES (2,1,'Reactive Java', 'Report about Java FX posiibilities');
INSERT INTO reports (report_id, conf_id, report_name, report_desk) VALUES (3,1,'JIT compilation', 'Report about JIT');
INSERT INTO reports (report_id, conf_id, report_name, report_desk) VALUES (4,1,'Jmm jdk 9', 'Report jmm at JDK 9');