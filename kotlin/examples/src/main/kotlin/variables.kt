/*
https://play.kotlinlang.org/byExample/01_introduction/03_Variables

Kotlin does not enforce immutability, though it is recommended.
 */

fun aCondition() = true;

private fun main() {
    var a: String = "java"
    val b: String = "kotlin"
    a = "kotlin" // mutable
    println(a)
    // b = "java" immutable!

    var c: Int
    if (aCondition()) {
        c = 100
    } else {
        c = -100
    }
    println(c)

    c = if (aCondition()) {
        20
    } else {
        -20
    }
}