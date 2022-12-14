package br.com.bercam.forum.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class AtualizacaoTopicoForm(
    @field:NotNull
    val id: Long,
    @field:NotEmpty
    @field:Size(min = 5, max = 200)
    val titulo: String,
    @field:NotEmpty
    val mensagem: String,
)
