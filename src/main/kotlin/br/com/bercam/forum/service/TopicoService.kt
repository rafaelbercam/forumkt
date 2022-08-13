package br.com.bercam.forum.service

import br.com.bercam.forum.model.Curso
import br.com.bercam.forum.model.Topico
import br.com.bercam.forum.model.Ususario
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicoService(private  var topicos: List<Topico>) {

    init {
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

        val topico2 = Topico(
            id = 2,
            titulo = "Duvidas Kotlin 2",
            mensagem = "Variaveis Kotlin 2",
            curso = Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "Programacao"
            ),
            autor = Ususario(
                id = 2,
                nome = "Ana Vitoria",
                email = "anavitoria@email.com"
            )
        )

        val topico3 = Topico(
            id = 3,
            titulo = "Duvidas Kotlin 3",
            mensagem = "Variaveis Kotlin 3" ,
            curso = Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "Programacao"
            ),
            autor = Ususario(
                id = 3,
                nome = "Manoel Carlos",
                email = "manoelcarlos@email.com"
            )
        )

        topicos =  Arrays.asList(topico, topico2, topico3)
    }
    fun listar(): List<Topico> {
        return topicos
    }

    fun buscarPorId(id: Long): Topico {
        return topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()

    }
}