package dojo

/**
https://www.codewars.com/kata/56484848ba95170a8000004d/train/kotlin
https://www.codewars.com/kata/58712dfa5c538b6fc7000569/train/kotlin
https://www.codewars.com/kata/587309155cfd6b9fb60000a0/train/kotlin
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

fun moneyValue(money:String):Double {
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

fun main() {
    gps(s = 100, doubleArrayOf(0.0, 0.23, 0.46, 0.69, 0.92, 1.15, 1.38, 1.61))
    countRedBeads(3)
    moneyValue("$$$")
}