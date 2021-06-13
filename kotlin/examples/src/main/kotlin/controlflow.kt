private data class Example(val data: String)

fun main() {
    val a = Example("bits and bytes")
    val b = a.copy()

    println("structural comparison: ${a == b}")
    println("referential comparison: ${a === b}")
}