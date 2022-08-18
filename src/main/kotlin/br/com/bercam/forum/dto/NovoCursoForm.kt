package br.com.bercam.forum.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class NovoCursoForm(
    @field:NotEmpty(message = "nome não pode ficar em branco")
    @field:Size(min = 3, message = "nome precisa no mínimo 3 caracteres")
    val nome: String,
    @field:NotEmpty(message = "categoria não pode ficar em branco")
    @field:Size(min = 3, message = "categoria precisa no mínimo 3 caracteres")
    val categoria: String
)