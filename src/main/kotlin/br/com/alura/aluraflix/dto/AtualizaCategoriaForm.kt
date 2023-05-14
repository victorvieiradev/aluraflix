package br.com.alura.aluraflix.dto

import jakarta.validation.constraints.NotNull

data class AtualizaCategoriaForm(
    @field:NotNull(message = "Informe o id")
    val id: Long?,
    val titulo: String?,
    val cor: String?
)