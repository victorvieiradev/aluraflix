package br.com.alura.aluraflix.dto

import jakarta.validation.constraints.NotEmpty

data class VideoFormDto(
    @field:NotEmpty(message = "Informe o título.")
    val titulo: String,
    @field:NotEmpty(message = "Informe a descrição.")
    val descricao: String,
    @field:NotEmpty(message = "Informe a url.")
    val url: String
)