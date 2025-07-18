-- Cachorros existentes com campo tipo_animal
INSERT INTO animal
(nome_provisorio, idade_estimada, raca, data_entrada, condicoes_chegada, nome_recebedor, porte, tipo_animal)
VALUES
    ('alvin', 12, 'cachorro', current_date, 'normal', 'Igor', 'pequeno', 'CACHORRO');

INSERT INTO animal
(nome_provisorio, idade_estimada, raca, data_entrada, condicoes_chegada, nome_recebedor, porte, tipo_animal)
VALUES
    ('Preta', 8, 'cachorro', current_date - 10, 'normal', 'Laura', 'Bem Grande', 'CACHORRO');

INSERT INTO animal
(nome_provisorio, idade_estimada, raca, data_entrada, condicoes_chegada, nome_recebedor, porte, data_adocao, tipo_animal)
VALUES
    ('Luan', 8, 'cachorro', current_date, 'meio sujo', 'Igor', 'medio', current_date, 'CACHORRO');

-- Novos gatos
INSERT INTO animal
(nome_provisorio, idade_estimada, raca, data_entrada, condicoes_chegada, nome_recebedor, porte, tipo_animal)
VALUES
    ('Mingau', 3, 'persa', current_date - 5, 'resfriado', 'Ana', 'pequeno', 'GATO');

INSERT INTO animal
(nome_provisorio, idade_estimada, raca, data_entrada, condicoes_chegada, nome_recebedor, porte, tipo_animal)
VALUES
    ('Salém', 5, 'preto comum', current_date - 20, 'assustado', 'Igor', 'medio', 'GATO');

INSERT INTO animal
(nome_provisorio, idade_estimada, raca, data_entrada, condicoes_chegada, nome_recebedor, porte, tipo_animal, data_adocao)
VALUES
    ('Luna', 2, 'siamês', current_date - 30, 'normal', 'Laura', 'pequeno', 'GATO', current_date - 2);
