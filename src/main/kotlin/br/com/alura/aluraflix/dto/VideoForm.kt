package br.com.alura.aluraflix.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class VideoForm(
    @field:NotBlank(message = "Informe o título.")
    val titulo: String?,
    @field:NotBlank(message = "Informe a descrição.")
    val descricao: String?,
    @field:NotBlank(message = "Informe a url.")
    val url: String?,
    @field:NotNull(message = "o id da categoria não pode estar nulo")
    val idCategoria: Long?
)