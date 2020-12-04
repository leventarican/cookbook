// https://www.codewars.com/kata/566fc12495810954b1000030/train/kotlin

// n (n >= 0)
// d (0 <= d <= 9)
fun nbDig(n:Int, d:Int):Int {
    var c = 0
    for (k in (0..n)) {
        val a = (k*k).toString().count { b -> Character.toString(b) == d.toString() }
        c += a
    }
    println(c)
    return c
}

fun main() {
    nbDig(10, 1)
    // println("needle in a haystack".count{ c -> c == 'a' })
}

// fun nbDig(n:Int, d:Int):Int = (0..n).map{ (it * it) }.sumBy { it.toString().count{ it == d.toString()[0] } }
// fun nbDig(n: Int, d: Int): Int = (0..n).joinToString { "${it * it}" }.count { "$it" == "$d" }
// fun nbDig(n:Int, d:Int) = (0..n).sumBy { (it * it).toString().count { it == Character.forDigit(d, 10) } }
// fun nbDig(n: Int, d: Int) =
//     (0..n)
//         .map { x -> "${x * x}" }
//         .joinToString("")
//         .filter { c -> "$c" == "$d" }
//         .count()
