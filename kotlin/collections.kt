fun log(msg: String): Unit {
    println("INFO - $msg")    
}

fun p() {
    println("# collections: pair")

    val j = Pair("java", 11)
    log("first: ${j.first}; second: ${j.second}")

    // with _syntactic sugar_
    val k = "kotlin" to 1.4
    log("first: ${k.first}; second: ${k.second}")
}

fun t() {
    println("# collections: triple")

    val green = Triple(0, 255, 0)
    log("rgb: ${green.first}, ${green.second}, ${green.third}")
}

fun a() {
    println("# collections: array")

    val i = intArrayOf(0, 10, 200)
    val n = arrayOfNulls<Int>(3)

    i.forEach {
        log("intArrayOf: $it")
    }

    n.forEach {
        log("arrayOfNulls: $it")   
    }
}

fun l() {
    println("# collections: lists")

    val numbers = listOf(0, 1, 2, 3, 3);
    val even = numbers.filter { it % 2 == 0 }
    log("even: $even")
    
    numbers.forEach { log("each number: $it") }
    numbers.iterator().forEach { log("it numbers: $it") }

    val computer = listOf("cpu", "memory", "disk")
    computer.forEach { log("computer: $it") }
}

fun s() {
    println("# collections: sets")

    val numbers = listOf(0, 1, 2, 3, 3);
    val binary = setOf(0, 1, 1, 1)
    log("binary: $binary")
    log("numbers (from list to set): ${numbers.toSet()}")
    val infinite = mutableSetOf(0, 1)
    infinite.add(7)
    infinite.addAll(numbers)
    log("infinite: $infinite")    
}

fun m() {
    println("# collections: maps")
    
    val stack = mutableMapOf<Int, String>(10 to "python", 11 to "rust")
    stack.put(0, "java")
    stack.put(1, "kotlin")
    log("$stack")    
}

/*
Collections: Pair, Triple, Array, List, Set, Map
*/
fun main() {
    p()
    t()
    a()
    l()
    s()
    m()
}