package br.com.alura.aluraflix.repository

import br.com.alura.aluraflix.model.VideoModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VideoRepository: JpaRepository<VideoModel, Long>