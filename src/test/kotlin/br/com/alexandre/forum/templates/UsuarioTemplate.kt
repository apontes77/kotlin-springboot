package br.com.alexandre.forum.templates

import br.com.alexandre.forum.model.Usuario

object UsuarioTemplate {
    fun build() = Usuario(id = 1, nome = "Bob", email = "bob@mail.com", password = "123")
    fun buildToToken() = Usuario(nome = "Mary", email = "mary@email.com", password = "123456")
}
