package functionalProgramming

// extension function and properties

data class Extensible(val x: Int)

fun Extensible.prettyPrint(): Unit = println("${this.javaClass.simpleName} is data class; arg x: $x; arg y: $y")
val Extensible.y: Int get() = 100

val String.foo: Int get() = 100

fun main() {
    val a = Extensible(1)
    println(a.x)
    a.prettyPrint()

    println("bar".foo)
}