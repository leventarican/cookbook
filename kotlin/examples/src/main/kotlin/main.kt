import java.lang.Math.random
import kotlin.system.measureTimeMillis

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

fun code0() {
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

fun expensiveCalculate() {
    Thread.sleep(100)
    println("expensive calculation done.")
}

data class Programmer(val name: String, val exp: Int)

private fun main() {
    val a = Programmer("kotlin", exp = 1)
    val b = Programmer("java", exp = 5)
    val developers = listOf(a, b)
    val c = developers.joinToString { p: Programmer -> p.exp.toString() }

    println(c)

    val d = { i: Int -> i + 30 + 10 }
    val e = d(100)
    println(e)

    val f = developers.maxByOrNull { p: Programmer -> p.exp }
    println(f)

    println("Kotlin version current: ${KotlinVersion.CURRENT}")

    val time = measureTimeMillis {
        expensiveCalculate()
    }
    println("time: $time")
}
