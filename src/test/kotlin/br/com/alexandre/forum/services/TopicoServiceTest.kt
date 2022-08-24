package br.com.alexandre.forum.services

import br.com.alexandre.forum.exception.NotFoundException
import br.com.alexandre.forum.mapper.TopicoFormMapper
import br.com.alexandre.forum.mapper.TopicoViewMapper
import br.com.alexandre.forum.repository.TopicoRepository
import br.com.alexandre.forum.service.TopicoService
import br.com.alexandre.forum.templates.TopicoTemplate
import br.com.alexandre.forum.templates.TopicoViewTemplate
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.ArgumentMatchers.anyLong
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import java.util.*

class TopicoServiceTest {

    val topicos = PageImpl(listOf(TopicoTemplate.build()))

    val repository: TopicoRepository = mockk {
        every { findByCursoNome(any(), any()) } returns topicos
    }

    val viewMapper: TopicoViewMapper = mockk {
        every { map(any()) } returns TopicoViewTemplate.build()
    }
    val formMapper: TopicoFormMapper = mockk()

    val topicoService = TopicoService(repository, viewMapper, formMapper)

    val paginacao: Pageable = mockk()

    @Test
    fun `deve listar os tópicos existentes`() {
        topicoService.listar("Kotlin avançado", paginacao)

        verify (exactly = 1){ repository.findByCursoNome(any(), any()) }
        verify (exactly = 0){ repository.findAll(paginacao) }
        verify (exactly = 1) { viewMapper.map(any()) }
    }

    @Test
    fun `deve listar todos os cursos se o nome do curso no parâmetro for nulo`() {
        every { repository.findAll(paginacao) } returns topicos
        topicoService.listar(null, paginacao)

        verify (exactly = 0) { repository.findByCursoNome(any(), any()) }
        verify (exactly = 1) { viewMapper.map(any()) }
        verify (exactly = 1) { repository.findAll(paginacao) }
    }

    @Test
    fun `deve lançar uma exceção quando não encontrar um livro por Id`() {

        every { repository.findById(any()) } returns Optional.empty()

        val atual = assertThrows<NotFoundException> {
            topicoService.buscarPorID(anyLong())
        }

        assertThat(atual.message).isEqualTo("Topico nao encontrado!")
    }
}