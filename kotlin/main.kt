
/*
compile:    kotlinc main.kt
run:        kotlin MainKt

or:         kotlinc main.kt && kotlin MainKt
*/

fun collections() {
    val numbers = listOf(0, 1, 2, 3, 4);
    val even = numbers.filter { it % 2 == 0 }
    log("even: $even")
    
    numbers.forEach { log("each number: $it") }
    numbers.iterator().forEach { log("it numbers: $it") }

    val computer = listOf("cpu", "memory", "disk")
    computer.forEach { log("computer: $it") }
}

fun loops(): Unit {
    for (i in (0..4)) {
        log("as usual: $i")
    }

    for (i in 0..5 step 2) {
        log("steps: $i")
    }

    for (i in 4 downTo 0 step 2) {
        log("countdown: $i")
    }
}

fun log(msg: String): Unit {
    println("INFO - $msg")    
}

fun add(a: Int, b: Int): Unit {
    val result = a + b
    println(result)
}

fun main() {
    println("kotlin.")
    log("test test test")

    val x = 7; add(3, x)

    loops()
    collections()
}