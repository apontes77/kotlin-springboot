package br.com.alexandre.forum.templates

import br.com.alexandre.forum.model.Curso

object CursoTemplate {

    fun build() = Curso(id = 1, nome = "Kotlin Basico", categoria = "Programacao")
}
