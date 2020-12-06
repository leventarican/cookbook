// https://www.codewars.com/kata/54bf1c2cd5b56cc47f0007a1/train/kotlin

// fun duplicateCount(text: String): Int {
//     println(text)
//     // aabbcde
//     // [, a, a, b, b, c, d, e, ]
//     // [, a, b, c, d, e]
//     val a = text.split("")
//     println(a)
    
//     val s = mutableSetOf<String>()
//     a.forEach { s.add(it) }
//     println(s)

//     val solution = a.size - s.size - 1
//     println(solution)

//     return solution
// }toUpperCase().

fun duplicateCount(text: String): Int {
    val a = text.toUpperCase().split("").filter {it.length > 0}.groupingBy {it}.eachCount().values.sumBy {
        if(it > 1) 1
        else 0
    }
    println(a)
    return a
}

fun main() {
    val a = "aabbcde"
    duplicateCount(a)
}

// fun duplicateCount(text: String) = text.groupBy(Char::toLowerCase).count { it.value.count() > 1 }