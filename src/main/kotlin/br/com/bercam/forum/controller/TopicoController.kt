package br.com.bercam.forum.controller

import br.com.bercam.forum.model.Curso
import br.com.bercam.forum.model.Topico
import br.com.bercam.forum.model.Ususario
import br.com.bercam.forum.service.TopicoService

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/topicos")
class TopicoController(private val service: TopicoService) {

    @GetMapping
    fun listar(): List<Topico> {
        return service.listar()
    }
}