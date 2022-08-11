package br.com.alexandre.forum.service

import br.com.alexandre.forum.controller.form.AtualizacaoTopicoForm
import br.com.alexandre.forum.controller.form.TopicoForm
import br.com.alexandre.forum.controller.view.TopicoView
import br.com.alexandre.forum.exception.NotFoundException
import br.com.alexandre.forum.mapper.TopicoFormMapper
import br.com.alexandre.forum.mapper.TopicoViewMapper
import br.com.alexandre.forum.model.Topico
import br.com.alexandre.forum.repository.TopicoRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService (
    private val repository: TopicoRepository,
    val topicoViewMapper: TopicoViewMapper,
    val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage: String = "Tópico não encontrado!"
    ){

    fun listar(): List<TopicoView> {
        return repository.findAll().stream().map {
            topico -> topicoViewMapper.map(topico)
        }.collect(Collectors.toList())
    }

    fun buscarPorID(id: Long): TopicoView {
      val topico = repository.findById(id)
          .orElseThrow{NotFoundException(notFoundMessage)}
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: TopicoForm) : TopicoView{
        val topico = topicoFormMapper.map(form)
        repository.save(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm) : TopicoView{
        var topico = repository.findById(form.id)
            .orElseThrow{NotFoundException(notFoundMessage)}
        topico.titulo = form.titulo
        topico.mensagem = form.mensagem
        return topicoViewMapper.map(topico)
    }

    fun excluir(id: Long) {
        repository.deleteById(id)
    }
}