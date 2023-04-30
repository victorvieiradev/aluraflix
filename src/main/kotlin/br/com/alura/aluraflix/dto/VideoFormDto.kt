package br.com.alura.aluraflix.dto

import jakarta.validation.constraints.NotBlank

data class VideoFormDto(
    @field:NotBlank(message = "Informe o título.")
    val titulo: String?,
    @field:NotBlank(message = "Informe a descrição.")
    val descricao: String?,
    @field:NotBlank(message = "Informe a url.")
    val url: String?
)