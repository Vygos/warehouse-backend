
set global time_zone = "-3:00";

create table empresa
(
    id_empresa            int          not null AUTO_INCREMENT,
    no_razao_social       varchar(100) not null,
    sigla_empresa         varchar(10)  not null,
    nr_cnpj_empresa       varchar(14)  not null,
    telefone_empresa      varchar(12),
    email_empresa         varchar(100),
    data_fundacao_empresa DATE,
    primary key (id_empresa)
) ENGINE = InnoDB
  CHARACTER SET = utf8;

create table cargo
(
    id_cargo int          not null auto_increment,
    ds_cargo varchar(100) not null,
    PRIMARY KEY (id_cargo)
) ENGINE = InnoDB
  CHARACTER SET = utf8;

create table usuario
(
    id_usuario int           not null AUTO_INCREMENT,
    email      varchar(100)  not null UNIQUE,
    secret     varchar(1000) not null,
    PRIMARY key (id_usuario)
) ENGINE = InnoDB
  CHARACTER SET = utf8;

create table responsavel
(
    id_responsavel              int          not null AUTO_INCREMENT,
    id_empresa                  int,
    id_cargo                    int          not null,
    id_usuario                  int          not null,
    no_responsavel              varchar(255) not null,
    data_nascimento_responsavel DATE,

    PRIMARY KEY (id_responsavel),
    FOREIGN KEY (id_empresa) references empresa (id_empresa),
    FOREIGN KEY (id_cargo) references cargo (id_cargo),
    FOREIGN KEY (id_usuario) references usuario(id_usuario)
) ENGINE = InnoDB
  CHARACTER SET = utf8;


create table permissao
(
    id_permissao int                 not null AUTO_INCREMENT,
    ds_permissao varchar(255) UNIQUE not null,
    PRIMARY KEY (id_permissao)
) ENGINE = InnoDB
  CHARACTER SET = utf8;

create table usuario_permissao
(
    id_usuario   int not null,
    id_permissao int not null,
    FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario),
    FOREIGN key (id_permissao) REFERENCES permissao (id_permissao)
) ENGINE = InnoDB
  CHARACTER SET = utf8;

create table setor
(
    id_setor int          not null AUTO_INCREMENT,
    ds_setor varchar(100) not null,
    PRIMARY KEY (id_setor)
) ENGINE = InnoDB
  CHARACTER SET = utf8;

create table produto
(
    id_produto     int          not null AUTO_INCREMENT,
    no_produto     varchar(255) not null,
    fabricante     varchar(255) not null,
    qtde_produto   int          not null,
    codigo_produto varchar(5)   not null,
    id_setor       int          not null,
    id_empresa     int          not null,
    PRIMARY KEY (id_produto),
    FOREIGN KEY (id_setor) references setor (id_setor),
    FOREIGN KEY (id_empresa) references empresa (id_empresa)
) ENGINE = InnoDB
  CHARACTER SET = utf8;

