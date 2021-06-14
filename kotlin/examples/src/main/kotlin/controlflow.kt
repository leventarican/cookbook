private data class Example(val data: String)

fun equalityChecks() {
    val a = Example("bits and bytes")
    val b = a.copy()

    println("structural comparison: ${a == b}")
    println("referential comparison: ${a === b}")
}

fun whenStatement() {
    var a : Any
    a = 10L
    when(a) {
        is String -> println("a String")
        !is String -> println("not an String")
    }

    val c = when(1) {
        1 -> "kotlin"
        else -> "java"
    }
    println(c)
}

fun main() {
    equalityChecks()
    whenStatement()
}