package br.com.alura.aluraflix.model

import jakarta.persistence.*

@Entity
data class Video(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val titulo: String,
    val descricao: String,
    val url: String,
    @ManyToOne
    val categoria: Categoria
)