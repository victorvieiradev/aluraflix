package br.com.alura.aluraflix.controller

import br.com.alura.aluraflix.dto.VideoFormDto
import br.com.alura.aluraflix.dto.VideoViewDto
import br.com.alura.aluraflix.service.VideoService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/videos")
class VideoController(
    private val videoService: VideoService
) {

    @PostMapping
    fun cadastrar(
        @RequestBody
        @Valid
        videoFormDto: VideoFormDto
    ): VideoViewDto {
        return videoService.cadastrar(videoFormDto)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ResponseEntity<VideoViewDto>{
return ResponseEntity.ok(videoService.buscarPorId(id))
    }
    @DeleteMapping("/{id}")
    fun excluir(@PathVariable id: Long): ResponseEntity<String> {
        videoService.excluir(id)
        return ResponseEntity.ok().body("Excluído.")
    }
}