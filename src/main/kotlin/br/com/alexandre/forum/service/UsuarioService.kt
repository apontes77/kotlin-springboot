package br.com.alexandre.forum.service

import br.com.alexandre.forum.model.Usuario
import br.com.alexandre.forum.repository.UsuarioRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UsuarioService(private val repository: UsuarioRepository) {

    fun buscarPorId(idAutor: Long): Usuario {
        return repository.findById(idAutor).get()
    }

}
