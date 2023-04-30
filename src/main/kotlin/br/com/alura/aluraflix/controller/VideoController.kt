package br.com.alura.aluraflix.controller

import br.com.alura.aluraflix.dto.VideoFormDto
import br.com.alura.aluraflix.dto.VideoViewDto
import br.com.alura.aluraflix.service.VideoService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriBuilder

@RestController
@RequestMapping("/videos")
class VideoController(
    private val videoService: VideoService
) {

    @PostMapping
    fun cadastrar(
        @RequestBody @Valid videoFormDto: VideoFormDto
    ): VideoViewDto {
        val videoCadastrado = videoService.cadastrar(videoFormDto)
        return videoCadastrado
    }
}