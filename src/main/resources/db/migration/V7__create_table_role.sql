create table role(
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome varchar(50) not null,
    primary key(id)
);

insert into role (id, nome) values (1, 'LEITURA-ESCRITA');
