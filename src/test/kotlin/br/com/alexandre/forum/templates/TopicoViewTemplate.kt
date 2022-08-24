package br.com.alexandre.forum.templates

import br.com.alexandre.forum.controller.view.TopicoView
import br.com.alexandre.forum.model.StatusTopico
import java.time.LocalDate
import java.time.LocalDateTime

class TopicoViewTemplate {
    companion object {
        fun build(): TopicoView {
            return TopicoView(
                id = 1L,
                titulo = "Kotlin avançado",
                mensagem = "",
                status = StatusTopico.NAO_SOLUCIONADO,
                dataCriacao = LocalDateTime.now(),
                dataAlteracao = LocalDate.now()
            )
        }
    }

}
