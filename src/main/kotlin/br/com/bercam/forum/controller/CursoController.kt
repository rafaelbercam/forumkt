package br.com.bercam.forum.controller

import br.com.bercam.forum.dto.CursoView
import br.com.bercam.forum.dto.NovoCursoForm
import br.com.bercam.forum.model.Curso
import br.com.bercam.forum.service.CursoService
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/cursos")
class CursoController(private val service: CursoService) {

    @GetMapping
    fun listar(): List<CursoView>{
        return service.listar()
    }

    @GetMapping("/{id}")
    fun listarPorId(@PathVariable id: Long): Curso {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody @Valid form: NovoCursoForm, uriBuilder: UriComponentsBuilder): ResponseEntity<CursoView>{
        val curso = service.cadastrar(form)
        val uri = uriBuilder.path("/cursos/${curso.id}").build().toUri()
        return ResponseEntity.created(uri).body(curso)
    }
}