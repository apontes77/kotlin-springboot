package br.com.alexandre.forum.templates

import br.com.alexandre.forum.model.Topico

object TopicoTemplate {
    fun build() = Topico(
        id = 1,
        titulo = "Kotlin Basico",
        mensagem = "Aprendendo kotlin basico",
        curso = CursoTemplate.build(),
        autor = UsuarioTemplate.build()
    )
}