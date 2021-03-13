fun datatypes() {
    val s = 1.toShort()
    val b = 1.toByte()
    val l = 1.toLong()
    val d = 1.toDouble()
    val i = 1.0.toInt()
    val c = 65.toChar()

    println("short: $s; byte: $b; long: $l; double: $d; int: $i; char: $c")
}

fun unit() {
    fun u() = Unit
    val u = u()
    println("Unit: $u")
}

fun main() {
    datatypes()
    unit()
}