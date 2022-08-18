package br.com.alexandre.forum.service

import br.com.alexandre.forum.model.Usuario
import br.com.alexandre.forum.repository.UsuarioRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UsuarioService(private val repository: UsuarioRepository): UserDetailsService {

    fun buscarPorId(idAutor: Long): Usuario {
        return repository.findById(idAutor).get()
    }

    override fun loadUserByUsername(username: String?): UserDetails {
       val usuario = repository.findByEmail(username) ?: throw RuntimeException()
        return UserDetail(usuario)
    }

}
