package br.com.alura.aluraflix.dto

import jakarta.validation.constraints.NotNull

data class AtualizaVideoForm(
    @field:NotNull(message = "Informe o id do vídeo a ser atualizado.")
    val id: Long,
    val titulo: String?,
    val descricao: String?,
    val url: String?
)