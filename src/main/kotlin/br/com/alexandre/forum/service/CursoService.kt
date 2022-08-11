package br.com.alexandre.forum.service

import br.com.alexandre.forum.model.Curso
import br.com.alexandre.forum.repository.CursoRepository
import org.springframework.stereotype.Service

@Service
class CursoService(private val repository: CursoRepository) {

    fun buscarPorId(id: Long): Curso {
        return repository.findById(id).get()
    }

}
