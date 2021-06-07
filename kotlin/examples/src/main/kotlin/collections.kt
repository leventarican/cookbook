import java.util.*

/*
https://kotlinlang.org/docs/collections-overview.html
https://play.kotlinlang.org/byExample/05_Collections/01_List
https://play.kotlinlang.org/byExample/05_Collections/03_Map
https://play.kotlinlang.org/byExample/05_Collections/11_partition

demonstration of collection extension functions
 */

fun collections() {
    // list: an ordered (access by index) collection. read-only or mutable
    val a = mutableListOf(1, 2, 0)
    val b = listOf(1, 2, 0)

    a.add(100)
    a.forEach { i -> print(i) }
    println("ordered collection: ${b[2]}")

    // set: an unordered collection. no duplicates. unique elements.
    val c = setOf(1, 1, 0)
    val d = mutableSetOf(1, 1, 0)
    println(c)

    // map: aka dictionary, key-value pairs
    val e = mapOf(0 to "kotlin", 1 to "java", 2 to "rust")
    val f = mutableMapOf(1 to 100, 2 to 200)
    e.forEach { (k, v) -> println("key: $k; value: $v") }
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

// split collection to pairs of lists using predicate
fun partition() {
    val a = listOf(100, 10, 1000, 10_000, -100)
    val (x, y) = a.partition { i -> i <= 100 }
    x.forEach { print("x: $it ") }
    y.forEach { print("y: $it ") }
}

fun main() {
    collections()
    ordering()
    transformation()
    partition()
}