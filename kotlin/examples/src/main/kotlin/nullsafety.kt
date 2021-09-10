/*
https://play.kotlinlang.org/byExample/01_introduction/04_Null%20Safety
https://kotlinlang.org/docs/null-safety.html#nullable-types-and-non-null-types

By default kotlin don't allow assigning null to a variable.
 */
private fun main() {
    var a: String = "kotlin"
    // a = null

    var b: String?
    b = null

    // if: unreachable code --> return value will be never java
    val c: String = if (b != null && b.length == 4) "java" else "kotlin"

    println(c)
}