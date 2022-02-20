package ar.edu.unsam.algo2.generics

import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe


class TestColeccionFiguritas : DescribeSpec({
    isolationMode = IsolationMode.InstancePerTest

    describe("Dada una colección de Figuritas,") {
        val coleccionFiguritas = Coleccion<Figurita>(cantidadObjetivo = 2)
        coleccionFiguritas.agregarElemento(Figurita(esHolograma = true))

        it("si la cantidad de elementos es menor a la de objetivo, no está completa") {
            coleccionFiguritas.estaCompleta() shouldBe false
        }

        it("si la cantidad de elementos es igual a la de objetivo, está completa") {
            coleccionFiguritas.agregarElemento(Figurita())
            coleccionFiguritas.estaCompleta() shouldBe true
        }

        it("completa y con por lo menos la mitad de sus elementos raros, es valiosa") {
            coleccionFiguritas.agregarElemento(Figurita())
            coleccionFiguritas.esValiosa() shouldBe true
        }

        it("completa y con menos de la mitad de sus elementos raros, no es valiosa") {
            with(coleccionFiguritas) {
                cantidadObjetivo = 3
                agregarElemento(Figurita())
                agregarElemento(Figurita())
            }
            coleccionFiguritas.esValiosa() shouldBe false
        }

    }

})