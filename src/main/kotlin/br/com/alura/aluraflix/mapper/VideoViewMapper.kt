package br.com.alura.aluraflix.mapper

import br.com.alura.aluraflix.dto.VideoViewDto
import br.com.alura.aluraflix.model.VideoModel

class VideoViewMapper: ToMapper<VideoModel, VideoViewDto>{
    override fun map(t: VideoModel): VideoViewDto {
        return VideoViewDto(
            id = t.id,
            titulo = t.titulo,
            descricao = t.descricao,
            url = t.url
        )
    }
}