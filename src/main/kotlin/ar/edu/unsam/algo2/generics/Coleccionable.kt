package ar.edu.unsam.algo2.generics

import java.time.LocalDate

interface Coleccionable {
    fun esRaro(): Boolean
}

val MAX_ANIO_RARO = 1930

class Auto(val fechaLanzamiento: LocalDate = LocalDate.now()) : Coleccionable {

    override fun esRaro() = fechaLanzamiento.year < MAX_ANIO_RARO
}

class Figurita(val esHolograma: Boolean = false) : Coleccionable {

    override fun esRaro() = esHolograma
}