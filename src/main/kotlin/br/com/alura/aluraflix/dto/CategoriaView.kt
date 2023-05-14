package br.com.alura.aluraflix.dto

data class CategoriaView(
    val id: Long?,
    val titulo: String,
    val cor: String,
    val videos: List<VideoDto>
)