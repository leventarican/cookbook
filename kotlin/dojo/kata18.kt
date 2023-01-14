
fun multiply(x: Double, y: Double) = x * y
/*
val multiply = { x: Double, y: Double -> x * y }
val multiply: (Double,Double) -> Double = Double::times
*/

// https://www.codewars.com/kata/5715eaedb436cf5606000381/train/kotlin
fun sum(numbers: IntArray): Int {
    val p = numbers.filter { it > 0 }.sum()
    return if (p>0) p else 0
}
/*
fun sum(numbers: IntArray) = numbers.sumBy{if(it>0) it else 0}
fun sum(numbers: IntArray): Int = numbers.sumOf { max(it, 0) }
fun sum(numbers: IntArray) = numbers.filter { it > 0 }.sumBy { i -> i }
fun sum(numbers: IntArray): Int = numbers.filterNot{it<0}.sum()
*/

// https://www.codewars.com/kata/5b180e9fedaa564a7000009a/train/kotlin
fun lowerOrUpper(s: String): String {
    val (upperCases, lowerCases) = s.partition { it.isUpperCase() }
    println(upperCases)
    println(lowerCases)
    return if (upperCases.length >= lowerCases.length) s.toUpperCase() else s.toLowerCase()
}
/*
fun solve(s: String): String = if (s.count { it.isLowerCase() } >= s.length/2.0) s.toLowerCase() else s.toUpperCase()
fun solve(s: String) = if (s.count(Char::isUpperCase) * 2 > s.length) s.toUpperCase() else s.toLowerCase()
fun solve(s: String) = if( s.sumBy { if(it.isUpperCase()) 1 else -1 } > 0) s.toUpperCase() else s.toLowerCase()
fun solve(s: String): String = s.count { it.isUpperCase() }.let { u ->
    if (u > s.count { it.isLowerCase() }) {
        s.toUpperCase()
    } else {
        s.toLowerCase()
    }
}
*/

fun main() {
    println("kata 18")

    val a = multiply(3.0, 34.0)
    println(a)

    val b = intArrayOf(1, -2, 3, 4, 5)
    val c = sum(b)
    println(c)

    val d = "coDe"
    val e = lowerOrUpper(d)
    println(e)
}