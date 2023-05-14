package br.com.alura.aluraflix.model

import jakarta.persistence.*

@Entity
data class Categoria(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val titulo: String,
    val cor: String,
    @OneToMany(mappedBy = "categoria")
    val videos: List<Video>?
)