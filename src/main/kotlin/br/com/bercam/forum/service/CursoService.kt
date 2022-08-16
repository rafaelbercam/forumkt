package br.com.bercam.forum.service

import br.com.bercam.forum.model.Curso
import br.com.bercam.forum.repository.CursoRepository
import org.springframework.stereotype.Service

@Service
class CursoService(private val repository: CursoRepository) {

    fun buscarPorId(id: Long): Curso {
        return repository.getReferenceById(id)
    }
}
