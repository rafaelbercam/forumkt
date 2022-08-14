package br.com.bercam.forum.mapper

interface Mapper<T, U> {
    fun map(t: T): U
}
