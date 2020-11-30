// https://www.codewars.com/kata/5715eaedb436cf5606000381/train/kotlin

// https://kotlinlang.org/docs/reference/collection-aggregate.html
fun sum(numbers: IntArray): Int {
    return numbers.filter { it > 0 }.sumBy { it }
}

fun main(args: Array<String>) {
    // var a = intArrayOf(1, 2, 3, 4, 5)
    // var a = intArrayOf(-1, -2, -3, -4, -5)
    var a = intArrayOf(1, -4, 7, 12)
    var r = sum(a)
    println(r)
}