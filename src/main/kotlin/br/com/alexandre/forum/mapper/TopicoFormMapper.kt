package br.com.alexandre.forum.mapper

import br.com.alexandre.forum.controller.form.TopicoForm
import br.com.alexandre.forum.model.Topico
import br.com.alexandre.forum.service.CursoService
import br.com.alexandre.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
    val cursoService: CursoService,
    val usuarioService: UsuarioService,): Mapper<TopicoForm, Topico> {

    override fun map(t: TopicoForm): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscarPorId(t.idAutor)
        )
    }
}