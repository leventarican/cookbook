
// https://www.codewars.com/kata/5526fc09a1bbd946250002dc/train/kotlin
fun find(integers: Array<Int>): Int {
    val c = integers.filter { it % 2 == 0 }
    val d = integers.filter { it % 2 != 0 }
    if ((c-d).count() == 1) {
        return (c-d).first()
    } else {
        return (d-c).first()
    }
}
/*
fun find(integers: Array<Int>) = integers.singleOrNull { it % 2 == 0 } ?: integers.single { it % 2 != 0 }
fun find(integers: Array<Int>): Int {
  val (even, odd) = integers.partition { it % 2 == 0 }
  return if (even.size == 1) even[0] else odd[0]
}
fun find(integers: Array<Int>) = integers.partition { it % 2 == 0 }.toList().minBy { it.size }!![0]
fun find(integers: Array<Int>): Int = integers.groupBy { it % 2 == 0 }.values.first { it.size == 1 }.first()
*/

fun main() {
    // 3
    val a = arrayOf(2,6,8,-10,3)
    val b = find(a)

    println(b)
}