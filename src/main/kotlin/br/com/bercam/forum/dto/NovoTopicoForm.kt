package br.com.bercam.forum.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class NovoTopicoForm(
    @field:NotEmpty(message = "Título não pode ficar em branco")
    @field:Size(min = 5, max = 200, message = "Título deve ter entre 5 e 100 caracteres")
    val titulo: String,
    @field:NotEmpty(message = "Mensagem não pode ficar em branco")
    val mensagem: String,
    @field:NotNull(message = "id do Curso não pode ficar nulo")
    val idCurso: Long,
    @field:NotNull(message = "id do Autor não pode ficar nulo")
    val idAutor: Long
)
