// https://www.codewars.com/kata/5583090cbe83f4fd8c000051/train/kotlin

fun extract(digits: String) = sequence {
    for (d in digits) {
        yield(d)
    }
}

fun digitize(n:Long):IntArray {
    val a = n.toString()
    val b = extract(a).take(a.length).map { Character.getNumericValue(it) }.toList().reversed().toIntArray()
    return b
}

fun main() {
    digitize(35231)
}

// fun digitize(n: Long) = "$n".reversed().map { "$it".toInt() }.toIntArray()

// fun digitize(n:Long):IntArray {
//     return n.toString().map(Character::getNumericValue).toIntArray().reversedArray()
// }
