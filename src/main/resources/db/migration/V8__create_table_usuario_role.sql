CREATE TABLE usuario_role(
    id BIGINT NOT NULL  AUTO_INCREMENT,
    usuario_id bigint NOT NULL,
    role_id bigint NOT NULL,
    primary key(id),
    foreign key(usuario_id) references usuario(id),
    foreign key(role_id) references role(id)
);

insert into usuario_role (id, usuario_id, role_id) values (1, 1, 1);
