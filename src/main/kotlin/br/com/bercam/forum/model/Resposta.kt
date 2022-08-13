package br.com.bercam.forum.model

import java.time.LocalDateTime


data class Resposta(
    val id: Long? = null,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val autor: Ususario,
    val topico: Topico,
    val solucao: Boolean
)