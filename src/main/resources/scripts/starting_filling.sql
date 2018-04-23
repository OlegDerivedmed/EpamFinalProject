REPLACE INTO roles (role_id, role_name) VALUES (1,'admin');
REPLACE INTO roles (role_id, role_name) VALUES (2,'moderator');
REPLACE INTO roles (role_id, role_name) VALUES (3,'speaker');
REPLACE INTO roles (role_id, role_name) VALUES (4,'user');
REPLACE INTO users (user_id, role_id, email, password) VALUES (777,1,'root','root');
