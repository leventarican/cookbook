
// https://www.codewars.com/kata/554b4ac871d6813a03000035/train/kotlin
fun highAndLow(numbers: String): String {
    val a = numbers.split(" ").map { it.toInt() }.sorted()
    println(a)
    return "${a.last()} ${a.first()}"
}
/*
fun highAndLow(numbers: String): String = numbers.split(" ").map { it.toInt() }.toIntArray().let { "${it.maxOrNull()} ${it.minOrNull()}" }
fun highAndLow(numbers: String) = numbers.split(" ").map { it.toInt() }.run { "${maxOrNull()} ${minOrNull()}" }
fun highAndLow(numbers: String): String {
    val stats = numbers.split(' ')
        .stream()
        .mapToInt { it.toInt() }
        .summaryStatistics()

    return "${stats.max} ${stats.min}"
}
 */

fun main() {
    highAndLow("1 9 -3 4 5")
    highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4")
    highAndLow("1 2 3")
}