package br.com.alura.aluraflix.controller

import br.com.alura.aluraflix.dto.CategoriaView
import br.com.alura.aluraflix.service.CategoriaService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
    fun buscarPorId(@PathVariable id: Long): CategoriaView{
        return categoriaService.buscarPorId(id)
    }
}