package br.com.alura.aluraflix.controller

import br.com.alura.aluraflix.dto.AtualizaVideoForm
import br.com.alura.aluraflix.dto.VideoFormDto
import br.com.alura.aluraflix.dto.VideoViewDto
import br.com.alura.aluraflix.service.VideoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/videos")
class VideoController(
    private val videoService: VideoService
) {

    @GetMapping
    fun listar(): MutableList<VideoViewDto> {
        return videoService.listar()
    }

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
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun atualizar(
        @RequestBody
        @Valid
        atualizaVideoForm: AtualizaVideoForm
    ): VideoViewDto {
        return videoService.atualiza(atualizaVideoForm)
    }
}