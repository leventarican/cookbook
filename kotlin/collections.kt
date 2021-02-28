fun log(msg: String): Unit {
    println("INFO - $msg")    
}

fun collections() {
    println("# collections: lists")
    val numbers = listOf(0, 1, 2, 3, 3);
    val even = numbers.filter { it % 2 == 0 }
    log("even: $even")
    
    numbers.forEach { log("each number: $it") }
    numbers.iterator().forEach { log("it numbers: $it") }

    val computer = listOf("cpu", "memory", "disk")
    computer.forEach { log("computer: $it") }

    println("# collections: sets")
    val binary = setOf(0, 1, 1, 1)
    log("binary: $binary")
    log("numbers (from list to set): ${numbers.toSet()}")
    val infinite = mutableSetOf(0, 1)
    infinite.add(7)
    infinite.addAll(numbers)
    log("infinite: $infinite")

    println("# collections: maps")
    val stack = mutableMapOf<Int, String>(10 to "python", 11 to "rust")
    stack.put(0, "java")
    stack.put(1, "kotlin")
    log("$stack")
}

fun main() {
    collections()
}