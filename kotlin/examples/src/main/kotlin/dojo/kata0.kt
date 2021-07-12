package dojo

import kotlin.system.exitProcess

/**
https://www.codewars.com/kata/56484848ba95170a8000004d/train/kotlin
https://www.codewars.com/kata/58712dfa5c538b6fc7000569/train/kotlin
https://www.codewars.com/kata/587309155cfd6b9fb60000a0/train/kotlin
https://www.codewars.com/kata/5544c7a5cb454edb3c000047/train/kotlin
https://www.codewars.com/kata/57f625992f4d53c24200070e/train/kotlin
https://www.codewars.com/kata/5839edaa6754d6fec10000a2/train/kotlin
*/

/*
distance from origin
 */
fun gps(s: Int, x: DoubleArray): Int {

    return 0
}

fun countRedBeads(nBlue: Int): Int =
    if (nBlue > 0) {
        val a = (nBlue - 1) * 2
        println("out $a")
        a
    } else {
        0
    }
/*
fun countRedBeads(nBlue: Int): Int = when {
  nBlue < 2 -> 0
  else -> (nBlue - 1) * 2
}
 */

fun moneyValue(money: String): Double {
    println("in: $money")
    val a = money.replace("$", "").replace(" ", "").toDoubleOrNull() ?: 0.0
    println("out: $a")
    return a
}
/*
fun moneyValue(money:String) = money.filter { it != ' ' && it != '$' }.toDoubleOrNull() ?: 0.0
fun moneyValue(money: String) = money.filter { it in "0123456789-." }.toDoubleOrNull() ?: 0.0
fun moneyValue(money:String):Double {
    var s = money.replace("[^0-9.-]".toRegex(), "").replace("^-$".toRegex(), "");

    if (s.isEmpty()) {
      return 0.0;
    } else {
      return s.toDouble();
    }
}
 */

fun bouncingBall(h: Double, bounce: Double, window: Double): Int {
    println("h: $h bounce: $bounce window: $window")
    if (bounce >= 1.0 || bounce < 0.0 || h < 0.0) {
        return -1
    }
    var a = h * bounce
    var b = -1
    if (h != window) {
        b = 1
    }
    while (a > window) {
        println("height $a")
        a *= bounce
        b += 2
    }
    println(b)
    return b
}
/*
val ans = ceil(log(window/h, bounce)).toInt() * 2 - 1
return if (ans > 0) ans else -1

if (h <= 0.0) return -1;
if (bounce <= 0.0 || bounce >= 1.0) return -1;
if (window >= h) return -1;
return generateSequence(h) { it * bounce }.takeWhile { it > window }.count() * 2 - 1
 */

fun bingo(ticket: Array<Pair<String, Int>>, win: Int): String {
    var a = 0
    ticket.forEach { p ->
        println("${p.first}; ${p.second}; $win")
        var win = false
        p.first.toCharArray().forEach {
            val c = it.toInt()
            if (!win) {
                if (c == p.second) {
                    println("found: $c ($it)")
                    win = true
                }
            }
        }
        if (win) {
            a++
        }
    }
    println("wins: $a")
    return if (a >= win) "Winner!" else "Loser!"
}

/*
fun bingo(ticket: Array<Pair<String, Int>>, win: Int) =
    if (ticket.count { it.second.toChar() in it.first } >= win) "Winner!" else "Loser!"

fun bingo(ticket: Array<Pair<String, Int>>, win: Int) =
    if (ticket.count { pair -> pair.first.any { it.toInt() == pair.second } } >= win) "Winner!" else "Loser!"

fun bingo(ticket: Array<Lot>, win: Int) = if(ticket.count(Lot::isMiniwin) >= win) "Winner!" else "Loser!"
private typealias Lot = Pair<String, Int>
private val Lot.isMiniwin get() = first.any { it.toInt() == second }

fun bingo(t: Array<Pair<String, Int>>, w: Int) =
    if (t.count { it.first.any { c -> c.toInt() == it.second } } >= w) "Winner!"
    else "Loser!"

fun bingo(ticket: Array<Pair<String, Int>>, win: Int): String {
    return when {
      ticket.map {
        it.first.map { it.toInt() }.contains(it.second)
      }.filter { it }.count() >= win -> "Winner!"
      else -> "Loser!"
    }
}

fun bingo(ticket: Array<Pair<String, Int>>, win: Int)=if(ticket.filter{it.first.contains(it.second.toChar())}.size<win)"Loser!" else "Winner!"

fun bingo(ticket: Array<Pair<String, Int>>, win: Int): String = ticket
    .sumBy { (s, n) ->
        if (s.any { it.toInt() == n }) 1
        else 0
    }
    .let {
        if (it >= win) "Winner!"
        else "Loser!"
    }
 */

fun findMissingLetter(array: CharArray): Char {
    var z = ' '.toChar()
    array.toList().zipWithNext { a, b ->
        val c = a.toInt() + 1
        if (c != b.toInt()) {
            z = c.toChar()
        }
    }
    println(z)
    return z
}
/*
fun findMissingLetter(array: CharArray) = (array.first()..array.last()).first { it !in array }
fun findMissingLetter(array: CharArray) = (array[0]..array[array.size - 1]).find { !array.contains(it) }
fun findMissingLetter(array: CharArray): Char = (array.first()..array.last()).subtract(array.toList()).first()
fun findMissingLetter(array: CharArray): Char = array.toList().zipWithNext().first { (current, next) -> next - current == 2}.second -1
for (i in 0 until arr.size - 1)
    if (arr[i] + 1 !in arr)
        return arr[i] + 1
return ' '
 */

fun main() {
    gps(s = 100, doubleArrayOf(0.0, 0.23, 0.46, 0.69, 0.92, 1.15, 1.38, 1.61))
    countRedBeads(3)
    moneyValue("$$$")
    bouncingBall(61.0, 1.1, 6.1)

    val data = arrayOf("HVAY" to 89, "LYH" to 65, "WEHEV" to 89, "MMQOZTB" to 77)
    bingo(data, 3)

    val s = data.sumBy { (a, b) ->
        if (b.toChar() in a) 1
        else 0
    }.let {
        if (it >= 1) "winner"
        else "looser"
    }
    println(s)

    findMissingLetter(charArrayOf('a', 'b', 'c', 'd', 'f'))

    val a = charArrayOf('a', 'b', 'c', 'e', 'f')
    for (i in 0 until a.size -1 ) {
        val b = a[i].toInt() + 1
        if (a[i+1].toInt() != b) {
            println("# ${b.toChar()}")
        }
    }

    val b = (a.first()..a.last()).toList()
    val c = a.toList()
    println(b)
    println(c)
    println(b - c)
    /*
    [a, b, c, d, e, f]
    [a, b, c, e, f]
    [d]
    */
    val d = ('a'..'z').toList()
    println(d)
    /*
    [a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z]
    */

    (0 until 10).toList().forEach {
        print(it)
    }
    val e = (0 .. 10).toList().windowed(2, 3).joinToString("")
    println(e)

    println(1.inc())
    println(1.inv())
}