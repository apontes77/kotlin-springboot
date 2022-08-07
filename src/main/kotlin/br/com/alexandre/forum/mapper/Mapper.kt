package br.com.alexandre.forum.mapper

interface Mapper<T,U> {
    fun map(t: T): U
}