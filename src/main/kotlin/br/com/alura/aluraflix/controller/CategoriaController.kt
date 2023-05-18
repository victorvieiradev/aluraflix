package br.com.alura.aluraflix.controller

import br.com.alura.aluraflix.dto.AtualizaCategoriaForm
import br.com.alura.aluraflix.dto.CategoriaForm
import br.com.alura.aluraflix.dto.CategoriaView
import br.com.alura.aluraflix.dto.VideoDto
import br.com.alura.aluraflix.service.CategoriaService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.stream.Stream

@RestController
@RequestMapping("/categorias")
class CategoriaController(
    private val categoriaService: CategoriaService
) {
    @GetMapping
    fun listar(): MutableList<CategoriaView> {
        return categoriaService.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): CategoriaView {
        return categoriaService.buscarPorId(id)
    }

    @DeleteMapping("/{id}")
    fun excluir(@PathVariable id: Long): ResponseEntity<String> {
        categoriaService.excluir(id)
        return ResponseEntity.ok().body("Excluído.")
    }
    @PostMapping
    fun cadastrar(@RequestBody @Valid categoriaForm: CategoriaForm): CategoriaView {
        return categoriaService.cadastrar(categoriaForm)
    }
    @PutMapping
    fun atualizar(@RequestBody @Valid atualizaCategoriaForm: AtualizaCategoriaForm): CategoriaView{
        return categoriaService.atualizar(atualizaCategoriaForm)
    }
    @GetMapping("/{id}/videos")
    fun listarVideos(@PathVariable id: Long): Stream<VideoDto>? {
        return categoriaService.listarVideos(id)
    }
}