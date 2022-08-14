package br.com.alexandre.forum.repository

import br.com.alexandre.forum.model.Curso
import br.com.alexandre.forum.model.Topico
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CursoRepository: JpaRepository<Curso, Long>{
}