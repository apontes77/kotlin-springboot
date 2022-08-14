package br.com.alexandre.forum.repository

import br.com.alexandre.forum.controller.TopicoPorCategoriaDto
import br.com.alexandre.forum.model.Topico
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface TopicoRepository: JpaRepository<Topico, Long>{
    fun findByCursoNome(nomeCurso: String, paginacao: Pageable): Page<Topico>
    @Query("SELECT new br.com.alexandre.forum.controller.TopicoPorCategoriaDto(curso.categoria, count(t)) FROM Topico t JOIN t.curso curso GROUP BY curso.categoria")
    fun relatorio(): List<TopicoPorCategoriaDto>

}