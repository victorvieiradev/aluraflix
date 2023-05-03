package br.com.alura.aluraflix.controller

import br.com.alura.aluraflix.dto.CategoriaForm
import br.com.alura.aluraflix.dto.CategoriaView
import br.com.alura.aluraflix.service.CategoriaService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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
    fun atualizar(){

    }
}