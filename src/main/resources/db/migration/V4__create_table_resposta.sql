CREATE TABLE resposta(
   id bigint NOT NULL auto_increment,
   mensagem VARCHAR(300) NOT NULL,
   data_criacao datetime NOT NULL,
   topico_id bigint NOT NULL,
   autor_id bigint NOT NULL,
   solucao INT(1) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(topico_id) REFERENCES topico(id),
   FOREIGN KEY(autor_id) REFERENCES usuario(id)
);