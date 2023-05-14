package br.com.alura.aluraflix.mapper

import br.com.alura.aluraflix.dto.VideoView
import br.com.alura.aluraflix.model.Video
import org.springframework.stereotype.Component

@Component
class VideoToVideoView: Mapper<Video, VideoView>{
    override fun map(t: Video): VideoView {
        return VideoView(
            id = t.id,
            titulo = t.titulo,
            descricao = t.descricao,
            url = t.url,
            categoria = CategoriaToCategoriaDto.map(t.categoria)
        )
    }
}