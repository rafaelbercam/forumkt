package br.com.bercam.forum.service

import br.com.bercam.forum.model.Curso
import br.com.bercam.forum.model.Topico
import br.com.bercam.forum.model.Ususario
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicoService {
    fun listar(): List<Topico> {
        val topico = Topico(
            id = 1,
            titulo = "Duvidas Kotlin",
            mensagem = "Variaveis Kotlin",
            curso = Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "Programacao"
            ),
            autor = Ususario(
                id = 1,
                nome = "Rafael Bercam",
                email = "bercam@email.com"
            )
        )

        return Arrays.asList(topico)
    }
}