package br.com.alura.aluraflix.mapper

interface ToMapper<T, U> {
    fun map(t: T): U

}
