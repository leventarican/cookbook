package dojo

/*
https://www.codewars.com/kata/56747fd5cb988479af000028

return the middle character of the word

Kata.getMiddle("test") should return "es"
Kata.getMiddle("middle") should return "dd"
 */

fun getMiddle(word : String) : String {
    val a = when (word.length % 2) {
        0 -> word.slice(word.length/2-1..word.length/2)
        // else odd case (= 1)
        else -> word.slice(word.length/2..word.length/2)
    }
    println(a)

    println(word.length % 2)

    return a
}

fun debug(word: String) = word.slice(word.length/2-(1-word.length%2)..word.length/2)

/*
fun getMiddle(w : String) : String {
    val len = w.length
    return w.substring (len / 2 - (len + 1) % 2, len / 2 + 1)
}

fun getMiddle(word : String) : String {
  return word.substring((word.length - 1) / 2, word.length / 2 + 1)
}

fun getMiddle(word : String) : String {
    val worldLength = (word.length - 1) / 2
    return word.drop(worldLength).dropLast(worldLength)
}

val o = if (word.length % 2 == 0) 1 else 0
val m = word.length / 2
return word.slice((m-o)..m)

fun getMiddle(word : String) = word.substring( (if (word.length % 2 == 0) word.length / 2 - 1 else word.length / 2) .. word.length / 2

fun getMiddle(word : String) : String {
    val l=word.length
    return word.substring (l/2 - (l+1)%2, l/2+1)
}

fun getMiddle(word: String): String = word.substring(word.length/2-Math.abs(word.length%2-1), word.length/2+1)
 */

fun main() {
    println(debug("test"))
    println(debug("middle"))
    println(debug("A"))
    println(debug("one"))
}