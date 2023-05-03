package br.com.alura.aluraflix.dto

import jakarta.validation.constraints.NotBlank

data class CategoriaForm(
    @field:NotBlank(message = "Informe o título.")
    val titulo: String?,
    @field:NotBlank(message = "Informe a cor.")
    val cor: String?
)