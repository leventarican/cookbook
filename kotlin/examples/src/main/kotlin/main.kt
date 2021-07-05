import objectOrientedProgramming.Status
import objectOrientedProgramming.Task

// memoized function: TODO
// fun double(x: Int) = x * 2

val cache = mutableMapOf<Int, Int>()
fun double(x: Int) =
    if (cache.containsKey(x)) {
        cache[x]
    } else {
        val result = x * 2
        cache[x] = result
        result
    }

data class Programmer(val name: String, val exp: Int)

fun main() {
    println("kotlin in action")

    val keyValue0 = "key" to "value"
    val keyValue1 = Pair<String, String>("kotlin", "java")
    println("syntax sugar. same expression but concise code: ${keyValue0.first} ")

    val (key, value) = keyValue0
    println("destruct a Pair: $key")

    val point = Triple(0, 1, 10)
    println("triples: $point")

    val a = listOf(Programmer("java", 10), Programmer("kotlin", 20))
    val b = a.maxOf { programmer: Programmer -> programmer.exp }
    println(b)
    val c = a.joinToString(" ", transform = { p: Programmer -> p.name })
    println(c)
}
