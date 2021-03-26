import objectOrientedProgramming.Status
import objectOrientedProgramming.Task

fun main() {
    println("kotlin in action")

    val keyValue0 = "key" to "value"
    val keyValue1 = Pair<String, String>("kotlin", "java")
    println("syntax sugar. same expression but concise code: ${keyValue0.first} ")

    val (key, value) = keyValue0
    println("destruct a Pair: $key")

    val point = Triple(0, 1, 10)
    println("triples: $point")
}
