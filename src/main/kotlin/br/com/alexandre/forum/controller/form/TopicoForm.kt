package br.com.alexandre.forum.controller.form

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class TopicoForm(
        @field:NotEmpty
        @field:Size(min=5, max = 100, message = "Título deve ter entre 5 e 100 caracteres")
        val titulo: String,
        @field:NotEmpty
        val mensagem: String,
        @field:NotNull
        val idCurso: Long,
        @field:NotNull
        val idAutor: Long
)
