package br.com.alura.aluraflix.service

import br.com.alura.aluraflix.dto.AtualizaCategoriaForm
import br.com.alura.aluraflix.dto.CategoriaForm
import br.com.alura.aluraflix.dto.CategoriaView
import br.com.alura.aluraflix.dto.VideoDto
import br.com.alura.aluraflix.exceptions.NotFoundException
import br.com.alura.aluraflix.mapper.CategoriaFormToCategoria
import br.com.alura.aluraflix.mapper.CategoriaToCategoriaView
import br.com.alura.aluraflix.mapper.VideoToVideoDto
import br.com.alura.aluraflix.model.Categoria
import br.com.alura.aluraflix.repository.CategoriaRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import java.util.stream.Stream

@Service
class CategoriaService(
    private val categoriaRepository: CategoriaRepository,
    private val categoriaToCategoriaView: CategoriaToCategoriaView,
    private val categoriaFormToCategoria: CategoriaFormToCategoria,
) {
    fun listar(): MutableList<CategoriaView> {
        return categoriaRepository.findAll().stream().map {
            categoriaToCategoriaView.map(it)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): CategoriaView {
        val categoria = categoriaRepository.findById(id).orElseThrow {
            NotFoundException("A categoria com o id $id não foi encontrada.")
        }
        return categoriaToCategoriaView.map(categoria)
    }

    fun excluir(id: Long) {
        val categoria = buscarPorId(id)
        categoriaRepository.deleteById(categoria.id!!)
    }

    fun cadastrar(categoriaForm: CategoriaForm): CategoriaView {
        val categoria = categoriaFormToCategoria.map(categoriaForm)
        val categoriaSalva = categoriaRepository.save(categoria)
        return categoriaToCategoriaView.map(categoriaSalva)
    }

    fun atualizar(atualizaCategoriaForm: AtualizaCategoriaForm): CategoriaView {
        val categoria = categoriaRepository.findById(atualizaCategoriaForm.id!!).orElseThrow{
            NotFoundException("Categoria não encontrada.")
        }
        return categoriaToCategoriaView.map(
            categoriaRepository.save(
                Categoria(
                    id = atualizaCategoriaForm.id,
                    titulo = atualizaCategoriaForm.titulo ?: categoria.titulo,
                    cor = atualizaCategoriaForm.cor ?: categoria.cor,
                    videos = categoria.videos

                )

            )
        )
    }

    fun listarVideos(id: Long): Stream<VideoDto>? {
        val categoria = categoriaRepository.findById(id)
        val videos = categoria.get().videos?.stream()?.map {
            VideoToVideoDto.map(it)
        }
        return videos
    }


}