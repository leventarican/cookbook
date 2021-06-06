package objectOrientedProgramming

/*
https://play.kotlinlang.org/byExample/07_Delegation/01_delegationPattern
 */

interface Paradigm {
    fun description()
}

class ObjectOrientatedProgramming(private val d: String) : Paradigm {
    override fun description() {
        println("oop development with: $d")
    }
}

class FunctionalProgramming(private val d: String) : Paradigm {
    override fun description() {
        println("functional programming with: $d")
    }
}

/*
old school way of delegation pattern implementation.
 */
class Java(private val d: String) {
    fun description() = ObjectOrientatedProgramming(d).description()
}

/*
kotlin way of delegation pattern.
delegate object is defined after the by.
no need to implement the method.
 */
class Kotlin(d: String) : Paradigm by FunctionalProgramming(d)

fun main() {
    Java("java").description()
    Kotlin("kotlin").description()
}
