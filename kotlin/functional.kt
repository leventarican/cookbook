// #############################################################################
// compile and run: kotlinc functional.kt && kotlin FunctionalKt
// #############################################################################

fun higher_order_functions(foo: Int, bar: Int, operation: (Int, Int) -> Int): Unit {
    println("higher order function: ${operation(foo, bar)}")
}

fun mul(x: Int, y: Int): Int {
    return x*y
} 

fun add(x: Int, y: Int) = x+y

fun String.debug(): String {
    return "$this debug (powered by extensions funcions)"
}

fun main() {
    higher_order_functions(3, 3, ::add)
    higher_order_functions(3, 3, ::mul)

    val anon = {
        println("anonymous / lambda functions")
    }
    anon()

    val s = "kotlin"
    println(s)
    println(s.debug())
}