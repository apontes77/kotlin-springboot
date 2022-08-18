package br.com.alexandre.forum.repository

import br.com.alexandre.forum.model.Topico
import br.com.alexandre.forum.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository: JpaRepository<Usuario, Long>{
    fun findByEmail(username: String?): Usuario?
}