package br.com.alexandre.forum.service

import br.com.alexandre.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class UsuarioService(var usuarios: List<Usuario>) {

    init {
        val usuario = Usuario(
            id = 1,
            nome = "Ana",
            email = "ana@mail.com"
        )
        usuarios = listOf(usuario)
    }

    fun buscarPorId(idAutor: Long): Usuario {
        return usuarios.stream()
            .filter { u -> u.id == idAutor }
            .findFirst().get()
    }

}
