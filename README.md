
## Generics Kotlin

[![build](https://github.com/uqbar-project/eg-generics-kotlin/actions/workflows/build.yml/badge.svg)](https://github.com/uqbar-project/eg-generics-kotlin/actions/workflows/build.yml) [![coverage](https://codecov.io/gh/uqbar-project/eg-generics-kotlin/branch/master/graph/badge.svg)](https://codecov.io/gh/uqbar-project/eg-generics-kotlin/branch/master/graph/badge.svg) 


Este ejemplo didáctico, muestra cómo utilizando **Generics**, podemos evitar la duplicación de código.

### El ejemplo

Estamos modelando el dominio para un coleccionista de autos, figuritas y otras posibles cosas.

- Los autos son raros si fueron fabricados antes de 1930
- las figuritas son raras si son un holograma

Queremos poder armar colecciones de autos o de figuritas y hacer operaciones con ellas:

- agregar elementos (que sean solo autos o figuritas)
- saber si completamos la colección (cuando llegamos a n elementos)
- saber cuántos elementos "raros" tenemos
- saber si hay mayoría de elementos raros 

entre otras cosas

> No nos interesa tener una colección polimórfica de elementos, pero sí poder armar distintas colecciones, ya sean de autos, de figuritas, o de cosas nuevas a futuro.

## Solución

Podés ver el ejemplo cómo definimos una colección de un tipo genérico `T`:

```kt
class Coleccion<T : Coleccionable>(var cantidadObjetivo: Int) {
    val elementos: MutableSet<T> = mutableSetOf<T>()


    fun agregarElemento(elemento: T) {
        elementos.add(elemento)
    }

    ...
```

Y luego cómo se usa en un test para armar una colección de figuritas:

```kt
describe("Dada una colección de Figuritas,") {
    val coleccionFiguritas = Coleccion<Figurita>(cantidadObjetivo = 2)
    coleccionFiguritas.agregarElemento(Figurita(esHolograma = true))
```
