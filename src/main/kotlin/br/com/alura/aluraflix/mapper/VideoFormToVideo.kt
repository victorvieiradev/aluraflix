package br.com.alura.aluraflix.mapper

import br.com.alura.aluraflix.dto.VideoForm
import br.com.alura.aluraflix.exceptions.NotFoundException
import br.com.alura.aluraflix.model.Video
import br.com.alura.aluraflix.repository.CategoriaRepository
import org.springframework.stereotype.Component

@Component
class VideoFormToVideo(
    private val categoriaRepository: CategoriaRepository
): Mapper<VideoForm, Video> {
    override fun map(t: VideoForm): Video {
        return Video(
            id = null,
            titulo = t.titulo!!,
            descricao = t.descricao!!,
            url = t.url!!,
            categoria = categoriaRepository.findById(t.idCategoria!!).orElseThrow{NotFoundException("Categoria não cadastrada")}
        )
    }
}