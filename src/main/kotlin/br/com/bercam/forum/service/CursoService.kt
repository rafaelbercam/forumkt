package br.com.bercam.forum.service

import br.com.bercam.forum.dto.CursoView
import br.com.bercam.forum.dto.NovoCursoForm
import br.com.bercam.forum.exception.NotFoundException
import br.com.bercam.forum.mapper.CursoFormMapper
import br.com.bercam.forum.mapper.CursoViewMapper
import br.com.bercam.forum.model.Curso
import br.com.bercam.forum.repository.CursoRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class CursoService(
    private val repository: CursoRepository,
    private var cursoFormMapper: CursoFormMapper,
    private var cursoViewMapper: CursoViewMapper,
    private var notFoundMessage: String = "Curso não encontrado"
    ) {

    fun buscarPorId(id: Long): Curso {
        val curso = repository.findById(id).orElseThrow{NotFoundException(notFoundMessage)}
        return curso
    }

    fun cadastrar(form: NovoCursoForm): CursoView {
        val curso = cursoFormMapper.map(form)
        repository.save(curso)
        return cursoViewMapper.map(curso)
    }

    fun listar(): List<CursoView> {
        return repository.findAll().stream().map { t-> cursoViewMapper.map(t) }.collect(Collectors.toList())
    }
}
