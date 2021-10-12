data class SpecialInt(val value: Int)
operator fun SpecialInt.plus(si: SpecialInt) = SpecialInt(this.value + si.value)

fun main() {
    val g = SpecialInt(4) + SpecialInt(2)
    println(g)
}
