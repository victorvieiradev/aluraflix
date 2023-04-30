package br.com.alura.aluraflix.dto

import jakarta.validation.constraints.NotEmpty

data class VideoFormDto(
    @field:NotEmpty(message = "O título não pode estar em branco.")
    val titulo: String,
    @field:NotEmpty(message = "A descrição não deve estar em branca.")
    val descricao: String,
    @field:NotEmpty(message = "A URL não deve estar em branca.")
    val url: String
)