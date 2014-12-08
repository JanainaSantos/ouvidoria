INSERT INTO tb_demandant_type(id, name, active) VALUES (nextval('tb_demandant_type_seq'), 'ANONIMO', true);
INSERT INTO tb_demandant_type(id, name, active) VALUES (nextval('tb_demandant_type_seq'), 'PESSOA FISICA', true);
INSERT INTO tb_demandant_type(id, name, active) VALUES (nextval('tb_demandant_type_seq'), 'PESSOA JURIDICA', true);
INSERT INTO tb_demandant_type(id, name, active) VALUES (nextval('tb_demandant_type_seq'), 'FUNCIONARIO', true);

INSERT INTO tb_identification(id, name, active) VALUES (nextval('tb_identification_seq'), 'IDENTIDADE', true);
INSERT INTO tb_identification(id, name, active) VALUES (nextval('tb_identification_seq'), 'CPF', true);
INSERT INTO tb_identification(id, name, active) VALUES (nextval('tb_identification_seq'), 'CNPJ', true);
INSERT INTO tb_identification(id, name, active) VALUES (nextval('tb_identification_seq'), 'MATRICULA', true);
