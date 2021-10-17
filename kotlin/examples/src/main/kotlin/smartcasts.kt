/*
https://play.kotlinlang.org/byExample/08_productivity_boosters/04_Smart%20Casts
 */

private fun main() {
//    val a: String? = null
    val a: String? = "200"

    if (a != null) {
        val nonNullable: Int = Integer.valueOf(a)
        println(nonNullable.plus(100))
    }

    if (a != null && Integer.valueOf(a).minus(100) == 100) {
        println("smart-cast")
    }

    var b: Any
    b = "KOTLIN"
    if (b is String) println("smart cast in action: ${b.lowercase()}")
}