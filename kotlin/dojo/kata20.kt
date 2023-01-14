
// https://codeforces.com/problemset/problem/4/A
// https://codeforces.com/contest/4

fun watermelon() : String {
    val input = readln().toInt()
    // corner / edge case
    if (input == 2) return "NO"
    return if(input % 2 == 0) "YES" else "NO"
}

// https://codeforces.com/problemset/problem/71/A
/*
fun waytoolongwords() {
    try {
        val input = generateSequence(::readln).joinToString("\n")
    } catch (eof: RuntimeException) {
        // signal EOF in console: CTRL+D
    }
}
 */

fun main() {
    //val output = watermelon()
    //val output = waytoolongwords()

    val a = "abaadefgh"
    val b = a.mapIndexed { i,_ -> Pair(i, a.substring(i).take(3)) }
    .filter { it.second.length.minus(it.second.toList().distinct().size) == 0 }
    .first()
    .first
    println("#$b")
}