/*
https://kotlinlang.org/docs/collections-overview.html

demonstration of collection extension functions
 */
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

    val c = a zip b
    c.forEach { pair -> println("${pair.first} - ${pair.second}") }
}

fun main() {
    ordering()
    transformation()
}