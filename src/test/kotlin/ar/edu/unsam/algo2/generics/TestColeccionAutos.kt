package ar.edu.unsam.algo2.generics

import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import java.time.LocalDate

class TestColeccionAutos : DescribeSpec({
    isolationMode = IsolationMode.InstancePerTest

    describe("Dada una colección de Autos,") {
        val coleccionAutos = Coleccion<Auto>(cantidadObjetivo = 3)
        coleccionAutos.agregarElemento(Auto(LocalDate.of(1929, 12, 31)))

        it("si esta incompleta no es valiosa") {
            coleccionAutos.esValiosa().shouldBeFalse()
        }

        it("si esta completa y la mayoria de sus elementos son raros, es valiosa") {
            coleccionAutos.apply {
                agregarElemento(Auto(LocalDate.of(1930, 1, 1)))
                agregarElemento(Auto(LocalDate.of(1928, 1, 1)))
            }
            coleccionAutos.esValiosa().shouldBeTrue()
        }

    }

})