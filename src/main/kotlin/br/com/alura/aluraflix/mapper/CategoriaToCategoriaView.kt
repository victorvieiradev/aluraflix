package br.com.alura.aluraflix.mapper

import br.com.alura.aluraflix.dto.CategoriaView
import br.com.alura.aluraflix.model.Categoria
import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
class CategoriaToCategoriaView: Mapper<Categoria, CategoriaView>{
    override fun map(t: Categoria): CategoriaView {
        return CategoriaView(
            id = t.id,
            titulo = t.titulo,
            cor = t.cor,
            videos = t.videos?.stream()?.map {
                VideoToVideoDto.map(it)
            }!!.collect(Collectors.toList())
        )
    }
}