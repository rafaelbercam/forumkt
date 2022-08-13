package br.com.bercam.forum.service

import br.com.bercam.forum.model.Curso
import br.com.bercam.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService(var usuarios: List<Usuario>) {

    init {
        val usuario = Usuario(
            id = 1,
            nome = "Ana Paula Padrao",
            email = "email@email.com"
        )
        usuarios = Arrays.asList(usuario)
    }

    fun buscarPorId(id: Long): Usuario {
        return usuarios.stream().filter { c ->
            c.id == id
        }.findFirst().get()
    }
}

