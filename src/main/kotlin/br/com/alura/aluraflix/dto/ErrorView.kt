package br.com.alura.aluraflix.dto

import java.time.LocalDateTime

data class ErrorView(
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val erro: String,
    val mensagem: String?,
    val path: String

)