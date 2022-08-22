package br.com.alexandre.forum.templates

import br.com.alexandre.forum.model.Usuario

object UsuarioTemplate {
    fun build() = Usuario(id = 1, nome = "Joao", email = "jvc.martins", password = "123")
    fun buildToToken() = Usuario(nome = "Ana da Silva", email = "ana@email.com", password = "123456")
}
