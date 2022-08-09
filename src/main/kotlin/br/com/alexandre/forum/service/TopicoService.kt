package br.com.alexandre.forum.service

import br.com.alexandre.forum.controller.form.AtualizacaoTopicoForm
import br.com.alexandre.forum.controller.form.TopicoForm
import br.com.alexandre.forum.controller.view.TopicoView
import br.com.alexandre.forum.exception.NotFoundException
import br.com.alexandre.forum.mapper.TopicoFormMapper
import br.com.alexandre.forum.mapper.TopicoViewMapper
import br.com.alexandre.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService (
    var topicos: List<Topico> = ArrayList(),
    val topicoViewMapper: TopicoViewMapper,
    val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage: String = "Tópico não encontrado!"
    ){

    fun listar(): List<TopicoView> {
        return topicos.stream().map {
            topico -> topicoViewMapper.map(topico)
        }.collect(Collectors.toList())
    }

    fun buscarPorID(id: Long): TopicoView {
      val topico = topicos.stream()
            .filter { t -> t.id == id }
            .findFirst().orElseThrow{NotFoundException(notFoundMessage)}

        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: TopicoForm) : TopicoView{
        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)

        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm) : TopicoView{
        var topico = topicos.stream().filter { t ->
            t.id == form.id
        }.findFirst().get()
        val topicoAtualizado = Topico(
            id = form.id,
            mensagem = form.mensagem,
            titulo = form.titulo,
            autor = topico.autor,
            curso = topico.curso,
            respostas = topico.respostas,
            status = topico.status,
            dataCriacao = topico.dataCriacao
        )
        topicos = topicos.minus(topico).plus(topicoAtualizado)
        return topicoViewMapper.map(topicoAtualizado)
    }

    fun excluir(id: Long) {
        var topico = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}

        topicos = topicos.minus(topico)
    }


}