package br.com.alura.aluraflix.service

import br.com.alura.aluraflix.dto.AtualizaCategoriaForm
import br.com.alura.aluraflix.dto.CategoriaForm
import br.com.alura.aluraflix.dto.CategoriaView
import br.com.alura.aluraflix.exceptions.NotFoundException
import br.com.alura.aluraflix.mapper.CategoriaFormMapper
import br.com.alura.aluraflix.mapper.CategoriaViewMapper
import br.com.alura.aluraflix.model.CategoriaModel
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
        categorias.forEach { categoria ->
            listaDeCategorias.add(categoriaViewMapper.map(categoria))
        }
        return listaDeCategorias
    }

    fun buscarPorId(id: Long): CategoriaView {
        val categoria = categoriaRepository.findById(id).orElseThrow {
            NotFoundException("A categoria com o id $id não foi encontrada.")
        }
        return categoriaViewMapper.map(categoria)
    }

    fun excluir(id: Long) {
        val categoria = buscarPorId(id)
        categoriaRepository.deleteById(categoria.id!!)
    }

    fun cadastrar(categoriaForm: CategoriaForm): CategoriaView {
        val categoria = categoriaFormMapper.map(categoriaForm)
        val categoriaSalva = categoriaRepository.save(categoria)
        return categoriaViewMapper.map(categoriaSalva)
    }

    fun atualizar(atualizaCategoriaForm: AtualizaCategoriaForm): CategoriaView {
        val categoria = buscarPorId(atualizaCategoriaForm.id!!)
return categoriaViewMapper.map(
    categoriaRepository.save(
        CategoriaModel(
            id = atualizaCategoriaForm.id,
            titulo = atualizaCategoriaForm.titulo ?: categoria.titulo,
            cor = atualizaCategoriaForm.cor ?: categoria.cor

        )

    )
)
    }
}