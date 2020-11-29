// https://www.codewars.com/kata/57eaeb9578748ff92a000009/train/kotlin

public fun sum(mixed: List<Any>): Int {
    var i = 0
    for (m in mixed) {
        println(m)
        when (m) {
            is Int -> i += m
            is String -> i += m.toInt()
        }
    }
    println("i: $i")
    return i;
}

fun main() {
    val a = listOf(5,"5")
    sum(a)
}

/*
public fun sum(mixed: List<Any>): Int = mixed.sumBy {
    when(it) {
        is Int -> it
        is String -> it.toInt()
        else -> 0
    }
}
*/