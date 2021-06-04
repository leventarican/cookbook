import java.util.*

/*
https://kotlinlang.org/docs/collections-overview.html
https://play.kotlinlang.org/byExample/05_Collections/01_List

demonstration of collection extension functions
 */

fun collections() {
    // list: an ordered collection. read-only or mutable
    val a = mutableListOf(1, 2, 0)
    val b = listOf(1, 2, 0)

    a.add(100)
    a.forEach { i -> print(i) }

    // set: an unordered collection. no duplicates
    val c = setOf(1, 1, 0)
    val d = mutableSetOf(1, 1, 0)
    println(c)
}

fun ordering() {
    val a = listOf(10, 2, 1, 90, 4, 700)
    println(a)

    // natural order
    val b = a.sorted()
    val c = a.sortedDescending()
    println(b)
    println(c)

    // custom order
    val d = a.sortedWith(compareBy { it < 9 })
    println(d)

    // reverse order
    val e = a.reversed()
    println(e)

    // random order
    val f = a.shuffled()
    println(f)
}

// collection transformation functions.
fun transformation() {
    val a = listOf("kotlin", "java", "rust")
    val b = listOf("v1.5", "v15", "v1.50")

    // zip: pair from two lists of same position
    val c = a zip b // or: a.zip(b)
    c.forEach { pair -> println("${pair.first} - ${pair.second}") }

    // flatten: nested collections (collections of collections)
    val d = listOf(listOf(0, 0, 1), listOf(0, 1, 0), listOf(1, 0, 0))
    println(d)    // [[0, 0, 1], [0, 1, 0], [1, 0, 0]]
    println(d.flatten())    // [0, 0, 1, 0, 1, 0, 1, 0, 0]

    // string representation
    val e = a.joinTo(StringBuffer("programming languages: "))
    println(e)  // programming languages: kotlin, java, rust
    val f = a.joinToString()
    println(f)
}

fun main() {
    collections()
    ordering()
    transformation()
}