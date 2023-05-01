package br.com.alura.aluraflix.mapper

import br.com.alura.aluraflix.dto.CategoriaForm
import br.com.alura.aluraflix.model.CategoriaModel
import org.springframework.stereotype.Component

@Component
class CategoriaFormMapper: ToMapper<CategoriaForm, CategoriaModel> {
    override fun map(t: CategoriaForm): CategoriaModel {
        return CategoriaModel(
            id = null,
            titulo = t.titulo,
            cor = t.cor
        )
    }
}