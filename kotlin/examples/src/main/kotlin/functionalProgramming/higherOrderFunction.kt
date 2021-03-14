package functionalProgramming

fun measure(function: () -> Unit) {
    val start = System.currentTimeMillis()
    function()
    val end = System.currentTimeMillis()

    println("# function duration [ms]: ${end - start}")
}

fun main() {
    measure {
        Thread.sleep(1000)
        println("# function operation done.")
    }
}