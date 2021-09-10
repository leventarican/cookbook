/*
https://play.kotlinlang.org/byExample/08_productivity_boosters/01_namedArguments

named arguments for methods and constructors
 */

class NamedArg(arg0 : Int, arg1: Int) {
    private var a = arg0
    private val b = arg1
    fun print() = println("named arguments: $a ; $b")
    fun str(s: String, optional: String) {
        a = Integer.valueOf(s)
        println("the optional value: $optional")
    }
}

private fun main() {
    val a = NamedArg(arg1 = 100, arg0 = 10)
    a.str("200", "works.")
    a.print()
}