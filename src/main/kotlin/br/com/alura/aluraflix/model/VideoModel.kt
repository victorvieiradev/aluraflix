package br.com.alura.aluraflix.model

import jakarta.persistence.Entity

@Entity
data class VideoModel(
    val id: Long?,
    val titulo: String,
    val descricao: String,
    val url: String
)