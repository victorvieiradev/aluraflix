package br.com.alura.aluraflix.mapper

import br.com.alura.aluraflix.dto.CategoriaDto
import br.com.alura.aluraflix.model.Categoria

object CategoriaToCategoriaDto: Mapper<Categoria, CategoriaDto> {
    override fun map(t: Categoria): CategoriaDto {
        return CategoriaDto(
            titulo = t.titulo
        )
    }
}