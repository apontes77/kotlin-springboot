package br.com.alexandre.forum.services

import br.com.alexandre.forum.mapper.TopicoFormMapper
import br.com.alexandre.forum.mapper.TopicoViewMapper
import br.com.alexandre.forum.repository.TopicoRepository
import br.com.alexandre.forum.service.TopicoService
import br.com.alexandre.forum.templates.TopicoTemplate
import io.mockk.every
import io.mockk.mockk
import org.springframework.data.domain.PageImpl

class TopicoServiceTest {

    val topicos = PageImpl(listOf(TopicoTemplate.build()))

    val repository: TopicoRepository = mockk{
        every { findByCursoNome(any(), any()) } returns topicos
    }
    val viewMapper: TopicoViewMapper = mockk()
    val formMapper: TopicoFormMapper = mockk()

    val topicoService = TopicoService(repository, viewMapper, formMapper)
}