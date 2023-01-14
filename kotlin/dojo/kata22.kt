
// https://www.codewars.com/kata/54ff3102c1bad923760001f3
fun getCount(str : String) : Int {
    val a = str.count { it in "aeiou" }
    println(a)
    return 0
}
/*
fun getCount(str: String) = str.sumBy {
    when (it) {
        'a', 'i', 'e', 'o', 'u' -> 1
        else -> 0
    }
}
*/

// https://www.codewars.com/kata/5667e8f4e3f572a8f2000039/train/kotlin
// accum("abcd") -> "A-Bb-Ccc-Dddd"
fun accum(str: String) : String {
    val a = str.mapIndexed { i,e -> e.toUpperCase().plus(e.toString().toLowerCase().repeat(i)) }
    .joinToString("-")
    println(a)
    return a
}
/*
fun accum(s: String): String = buildString {
    s.withIndex().forEach { c ->
        append(c.value.toLowerCase().toString().repeat(c.index + 1).capitalize())
        append("-")
    }
}.dropLast(1)
*/

// https://www.codewars.com/kata/511f11d355fe575d2c000001/train/kotlin
fun twoOldestAges(ages: List<Int>): List<Int> {
    val a = ages.sorted().takeLast(2)
    println(a)
    return a
}
/*
fun twoOldestAges(ages: List<Int>): List<Int>  = ages.sorted().reversed().slice(0..1).reversed()
fun twoOldestAges(ages: List<Int>): List<Int> {
    var max1 = Int.MIN_VALUE
    var max2 = Int.MIN_VALUE
    for (age in ages) {
        if (age > max1) {
            max2 = max1
            max1 = age
        } else if (age > max2) {
            max2 = age
        }
    }
    return listOf(max2, max1)
}
*/

fun main() {
    // 5
    getCount("abracadabra")
    accum("abcd")
    twoOldestAges(listOf(1,5,87,45,8,8))
}