-- Dados "dummy" para execucao do sistema a nivel de testes

insert into perfil(id,nome,descricao) values(nextval('PERFIL_SEQ'),'administrador','...');
insert into perfil(id,nome,descricao) values(nextval('PERFIL_SEQ'),'convidado','...');

-- pedro=123
-- convidado=convidado
insert into usuario(id,login,senha,nome,email,ramal,perfil_fk) values(nextval('USUARIO_SEQ'),'pedro','ICy5YqxZB1uWSwcVLSNLcA==','Pedro Costa','phtcosta@hotmail.com','6441',1);
insert into usuario(id,login,senha,nome,email,ramal,perfil_fk) values(nextval('USUARIO_SEQ'),'convidado','RGwFXlkc6QfevueOX3Gx/Q==','Convidado','convidado@hotmail.com','-',2);

insert into forma_contato(id,nome,descricao) values(nextval('FORMA_CONTATO_SEQ'),'E-mail','Contato feito atraves de email');
insert into forma_contato(id,nome,descricao) values(nextval('FORMA_CONTATO_SEQ'),'Telefone','Contato feito atraves de telefone');
insert into forma_contato(id,nome,descricao) values(nextval('FORMA_CONTATO_SEQ'),'Carta','Contato feito atraves de carta');
insert into forma_contato(id,nome,descricao) values(nextval('FORMA_CONTATO_SEQ'),'Pessoalmente','Contato feito pessoalmente');
insert into forma_contato(id,nome,descricao) values(nextval('FORMA_CONTATO_SEQ'),'Site','Contato feito atraves do site da ouvidoria');

insert into tipo_demanda(id,nome,descricao) values(nextval('TIPO_DEMANDA_SEQ'),'Critica','...');
insert into tipo_demanda(id,nome,descricao) values(nextval('TIPO_DEMANDA_SEQ'),'Denuncia','...');
insert into tipo_demanda(id,nome,descricao) values(nextval('TIPO_DEMANDA_SEQ'),'Elogio','...');
insert into tipo_demanda(id,nome,descricao) values(nextval('TIPO_DEMANDA_SEQ'),'Reclamacao','...');
insert into tipo_demanda(id,nome,descricao) values(nextval('TIPO_DEMANDA_SEQ'),'Sugestao','...');

insert into tipo_demandante(id,nome,descricao) values(nextval('TIPO_DEMANDANTE_SEQ'),'Cidadao','...');
insert into tipo_demandante(id,nome,descricao) values(nextval('TIPO_DEMANDANTE_SEQ'),'Empresa','...');
insert into tipo_demandante(id,nome,descricao) values(nextval('TIPO_DEMANDANTE_SEQ'),'Empregado','...');
insert into tipo_demandante(id,nome,descricao) values(nextval('TIPO_DEMANDANTE_SEQ'),'Terceirizado','...');
insert into tipo_demandante(id,nome,descricao) values(nextval('TIPO_DEMANDANTE_SEQ'),'Estagiario','...');

insert into assunto(id,nome,descricao) values(nextval('ASSUNTO_SEQ'),'Agricultura Familiar','...');
insert into assunto(id,nome,descricao) values(nextval('ASSUNTO_SEQ'),'Estoques Publicos','...');
insert into assunto(id,nome,descricao) values(nextval('ASSUNTO_SEQ'),'Programas de Subvencao Economica','...');
insert into assunto(id,nome,descricao) values(nextval('ASSUNTO_SEQ'),'Doacao de Alimentos','...');
insert into assunto(id,nome,descricao) values(nextval('ASSUNTO_SEQ'),'Armazenagem','...');
insert into assunto(id,nome,descricao) values(nextval('ASSUNTO_SEQ'),'Convenios e Transferencias','...');
insert into assunto(id,nome,descricao) values(nextval('ASSUNTO_SEQ'),'PNUD','...');
insert into assunto(id,nome,descricao) values(nextval('ASSUNTO_SEQ'),'Levantamento de Safras','...');
insert into assunto(id,nome,descricao) values(nextval('ASSUNTO_SEQ'),'Recursos Financeiros/Orcamentarios/Contabil','...');
insert into assunto(id,nome,descricao) values(nextval('ASSUNTO_SEQ'),'Recursos Humanos','...');
insert into assunto(id,nome,descricao) values(nextval('ASSUNTO_SEQ'),'Recursos Materiais','...');
insert into assunto(id,nome,descricao) values(nextval('ASSUNTO_SEQ'),'Patrimonio','...');
insert into assunto(id,nome,descricao) values(nextval('ASSUNTO_SEQ'),'Tecnologia da Informacao','...');
insert into assunto(id,nome,descricao) values(nextval('ASSUNTO_SEQ'),'Licitacao e Contratos','...');
insert into assunto(id,nome,descricao) values(nextval('ASSUNTO_SEQ'),'Outros ...','...');

insert into estado values(nextval('ESTADO_SEQ'),'Distrito Federal','DF');
insert into cidade values(nextval('CIDADE_SEQ'),'Brasilia',1);

