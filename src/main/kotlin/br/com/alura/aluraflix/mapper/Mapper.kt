package br.com.alura.aluraflix.mapper

interface Mapper<T, U> {
    fun map(t: T): U

}
