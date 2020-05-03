INSERT INTO `qniversity-api`.turno (id, descricao, inicio, fim) VALUES (3, 'NOTURNO', '18:00:00', '23:59:59');
INSERT INTO `qniversity-api`.turno (id, descricao, inicio, fim) VALUES (2, 'VESPERTINO', '12:00:00', '17:59:59');
INSERT INTO `qniversity-api`.turno (id, descricao, inicio, fim) VALUES (1, 'MATUTINO', '06:00:00', '11:59:59');
INSERT INTO `qniversity-api`.turno (id, descricao, inicio, fim) VALUES (4, 'MADRUGADA', '00:00:00', '05:59:59');

INSERT INTO `qniversity-api`.curso (id, nome, qtd_periodos) VALUES (1, 'Ciência da Computação', 8);
INSERT INTO `qniversity-api`.curso (id, nome, qtd_periodos) VALUES (2, 'Sistema da Informação', 8);
INSERT INTO `qniversity-api`.curso (id, nome, qtd_periodos) VALUES (3, 'Análise e Desenvolvimento de Sistemas', 5);
INSERT INTO `qniversity-api`.curso (id, nome, qtd_periodos) VALUES (4, 'Engenharia da Computação', 8);

insert into usuario (id, email, password, profile) values (1, 'walicen.r@gmail.com', '$2a$10$5ZDoLhEtGKvumT9.aLsOEunpJyUs.Ul9PEU1c.MAueRH7LN54C61.', 1);

INSERT INTO `qniversity-api`.aluno (id, email, nome, ranking, sobrenome, telefone, turma_id, usuario_id) VALUES (1, 'jean.s@gmail.com', 'Jean', true, 'Silva', '4199887744', null, null);
INSERT INTO `qniversity-api`.aluno (id, email, nome, ranking, sobrenome, telefone, turma_id, usuario_id) VALUES (2, 'vanderlei.s@gmail.com', 'Vanderlei', true, 'Silva', '4199887744', null, null);
INSERT INTO `qniversity-api`.aluno (id, email, nome, ranking, sobrenome, telefone, turma_id, usuario_id) VALUES (3, 'walicen.r@gmail.com', 'Walicen', true, 'Dalazuana', '4199887744', null, null);