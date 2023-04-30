package br.com.alura.aluraflix.mapper

import br.com.alura.aluraflix.dto.VideoFormDto
import br.com.alura.aluraflix.model.VideoModel
import org.springframework.stereotype.Component

@Component
class VideoFormDtoMapper: ToMapper<VideoFormDto, VideoModel> {
    override fun map(t: VideoFormDto): VideoModel {
        return VideoModel(
            id = null,
            titulo = t.titulo,
            descricao = t.descricao,
            url = t.url
        )
    }
}