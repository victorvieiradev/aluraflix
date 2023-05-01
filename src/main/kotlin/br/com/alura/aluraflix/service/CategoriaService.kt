package br.com.alura.aluraflix.service

import br.com.alura.aluraflix.dto.CategoriaView
import br.com.alura.aluraflix.mapper.CategoriaFormMapper
import br.com.alura.aluraflix.mapper.CategoriaViewMapper
import br.com.alura.aluraflix.repository.CategoriaRepository
import org.springframework.stereotype.Service

@Service
class CategoriaService(
    private val categoriaRepository: CategoriaRepository,
    private val categoriaViewMapper: CategoriaViewMapper,
    private val categoriaFormMapper: CategoriaFormMapper
) {
    fun listar(): MutableList<CategoriaView> {
        val listaDeCategorias = mutableListOf<CategoriaView>()
        val categorias = categoriaRepository.findAll()
        categorias.forEach {
            categoria ->
            listaDeCategorias.add(categoriaViewMapper.map(categoria))
        }
        return listaDeCategorias
    }
}