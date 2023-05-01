package br.com.alura.aluraflix.mapper

import br.com.alura.aluraflix.dto.CategoriaView
import br.com.alura.aluraflix.model.CategoriaModel
import org.springframework.stereotype.Component

@Component
class CategoriaViewMapper: ToMapper<CategoriaModel, CategoriaView>{
    override fun map(t: CategoriaModel): CategoriaView {
        return CategoriaView(
            id = t.id,
            titulo = t.titulo,
            cor = t.cor
        )
    }
}