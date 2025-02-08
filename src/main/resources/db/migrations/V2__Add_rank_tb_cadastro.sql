-- V2: Migration para adiconar coluna RANK na tabela de Cadastro

ALTER TABLE tb_cadastro
ADD COLUMN rank VARCHAR(255);