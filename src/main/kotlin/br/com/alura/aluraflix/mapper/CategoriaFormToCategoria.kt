package br.com.alura.aluraflix.mapper

import br.com.alura.aluraflix.dto.CategoriaForm
import br.com.alura.aluraflix.model.Categoria
import org.springframework.stereotype.Component

@Component
class CategoriaFormToCategoria: Mapper<CategoriaForm, Categoria> {
    override fun map(t: CategoriaForm): Categoria {
        return Categoria(
            id = null,
            titulo = t.titulo!!,
            cor = t.cor!!,
            videos = listOf()
        )
    }
}