package br.com.alura.aluraflix.controller

import br.com.alura.aluraflix.dto.AtualizaVideoForm
import br.com.alura.aluraflix.dto.VideoForm
import br.com.alura.aluraflix.dto.VideoView
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
    fun listar(
        @RequestParam(required = false)
        search: String?
    ): MutableList<VideoView> {
        return videoService.listar(search)
    }

    @PostMapping
    fun cadastrar(
        @RequestBody
        @Valid
        videoForm: VideoForm
    ): VideoView {
        return videoService.cadastrar(videoForm)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ResponseEntity<VideoView>{
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
    ): VideoView {
        return videoService.atualiza(atualizaVideoForm)
    }
}