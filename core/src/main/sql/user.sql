INSERT INTO tb_role(id, name, active) VALUES (nextval('tb_role_seq'), 'OPERATOR', true);
INSERT INTO tb_role(id, name, active) VALUES (nextval('tb_role_seq'), 'OMBUDSMAN', true);

-- password=123
INSERT INTO tb_user(id, name, login, password, email, active, role_fk) VALUES (nextval('tb_USER_seq'), 'admin', 'admin', '{MD5}ICy5YqxZB1uWSwcVLSNLcA==', '', true, (select id from tb_role where name = 'OMBUDSMAN'));

-- create views for tomcate realm
CREATE OR REPLACE VIEW vw_users AS SELECT name as user_name, password FROM tb_user;

CREATE OR REPLACE VIEW vw_user_roles AS SELECT u.name as user_name, r.name as role_name FROM tb_user as u, tb_role as r WHERE u.role_fk = r.id;