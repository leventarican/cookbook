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

fun main() {
    higher_order_functions(3, 3, ::add)
    higher_order_functions(3, 3, ::mul)
}