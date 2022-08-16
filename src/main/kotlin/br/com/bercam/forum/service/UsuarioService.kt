package br.com.bercam.forum.service

import br.com.bercam.forum.model.Curso
import br.com.bercam.forum.model.Usuario
import br.com.bercam.forum.repository.UsuarioRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService(private val repository: UsuarioRepository) {

    fun buscarPorId(id: Long): Usuario {
        return repository.getReferenceById(id)
    }
}

