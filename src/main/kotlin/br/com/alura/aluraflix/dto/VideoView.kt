package br.com.alura.aluraflix.dto

data class VideoView(
    val id: Long?,
    val titulo: String,
    val descricao: String,
    val url: String,
    val categoria: CategoriaDto
)