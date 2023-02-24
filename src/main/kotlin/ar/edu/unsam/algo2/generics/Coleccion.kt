package ar.edu.unsam.algo2.generics

class Coleccion<T : Coleccionable>(var cantidadObjetivo: Int) {
    val elementos: MutableSet<T> = mutableSetOf<T>()

    fun agregarElemento(elemento: T) {
        elementos.add(elemento)
    }

    fun estaCompleta() = elementos.count() >= cantidadObjetivo

    fun esValiosa() = mayoriaElementosRaros() && estaCompleta()

    fun mayoriaElementosRaros() = cantidadElementosRaros() >= cantidadMitadElementos()

    fun cantidadMitadElementos() = elementos.count() / 2.0

    fun cantidadElementosRaros() = elementos.count { it.esRaro() }
}