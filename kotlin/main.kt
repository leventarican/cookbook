
/*
compile:    kotlinc main.kt
run:        kotlin MainKt

or:         kotlinc main.kt && kotlin MainKt
*/

fun log(msg: String): Unit {
    println("INFO $msg")    
}

fun add(a: Int, b: Int): Unit {
    val result = a + b
    println(result)
}

fun main() {
    println("kotlin.")
    log("test test test")

    val x = 7
    add(3, x)
}