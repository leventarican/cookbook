// https://www.codewars.com/kata/55cbc3586671f6aa070000fb/train/kotlin

// ex. base: 6; factor: 2 and 3
fun checkForFactor(base: Int, factor: Int): Boolean {

    val a = base % factor == 0
    println(a)
    return a
}

fun main() {
    checkForFactor(10, 2)
}
