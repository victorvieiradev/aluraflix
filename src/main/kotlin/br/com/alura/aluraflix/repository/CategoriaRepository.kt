package br.com.alura.aluraflix.repository

import br.com.alura.aluraflix.model.Categoria
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoriaRepository: JpaRepository<Categoria, Long>