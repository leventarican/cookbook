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
    private val p: Paradigm = ObjectOrientatedProgramming(d)
    fun description() = p.description()
}

/*
kotlin way of delegation pattern.
delegate object is defined after the by.
no need to implement the method.
 */
class Kotlin(d: String) : Paradigm by FunctionalProgramming(d)

class StandardDelegates() {
    val lazyValue: String by lazy {
        // not init yet
        // println("# ${this.lazyValue}")
        println("# by lazy delegate is provided by kotlin std library")
        "a lazy value"
    }
}

fun main() {
    Java("java").description()
    Kotlin("kotlin").description()

    val a = StandardDelegates()
    println(a.lazyValue)
}
