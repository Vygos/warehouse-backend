INSERT INTO WAREHOUSE.cargo (ds_cargo)
VALUES ('Estoquista'),
       ('Gerente de Estoque'),
       ('Auxiliar Administrativo'),
       ('Gerente de Administrativo');

INSERT INTO WAREHOUSE.setor (ds_setor)
VALUES ('Alimentícios'),
       ('Higiene'),
       ('Roupas'),
       ('Bebidas'),
       ('Produtos de limpeza'),
       ('Artesanal');

# Password decoded is -> "admin"
INSERT INTO WAREHOUSE.usuario (email, secret)
VALUES ('admin@warehouse.com', '$2a$10$N3TDQy39c2HoxsHrwFA2Qewsh4S1Vj.r0.dKL8e8rjF8ZYgOFEieK');

INSERT INTO WAREHOUSE.permissao (ds_permissao)
VALUES ('ROLE_CADASTRAR'),
       ('ROLE_VISUALIZAR'),
       ('ROLE_DELETAR'),
       ('ROLE_EDITAR'),
       ('ROLE_ADMIN');

#ADDING ALL PERMISSIONS TO USER ADMIN
INSERT INTO WAREHOUSE.usuario_permissao (id_usuario, id_permissao)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (1, 5);

