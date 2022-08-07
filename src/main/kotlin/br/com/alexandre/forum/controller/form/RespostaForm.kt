package br.com.alexandre.forum.controller.form

import javax.validation.constraints.NotEmpty

data class RespostaForm(@field:NotEmpty
                   val mensagem: String,
                   val idAutor: Long
)
