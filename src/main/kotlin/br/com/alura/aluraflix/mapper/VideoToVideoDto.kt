package br.com.alura.aluraflix.mapper

import br.com.alura.aluraflix.dto.VideoDto
import br.com.alura.aluraflix.model.Video

object VideoToVideoDto: Mapper<Video, VideoDto> {
    override fun map(t: Video): VideoDto {
        return VideoDto(
            titulo = t.titulo,
            descricao = t.descricao,
            url = t.url
        )
    }
}