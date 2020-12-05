// https://www.codewars.com/kata/56541980fa08ab47a0000040/train/kotlin

fun printerError(s: String): String {
    val a = "abcdefghijklm"
    var e = 0
    s.forEach {
        println(it)
        if(it !in a) e++
    }
    var solution = "$e/${s.length}"
    println(solution)
    return solution
}  

fun main(args: Array<String>) {
    val e = "aaaxbbbbyyhwawiwjjjwwm"
    val a = "8/22"
    printerError(e)
}

// fun printerError(s: String) = "${s.count { it !in 'a'..'m' }}/${s.length}"
// fun printerError(s: String): String {
//     return "${s.count{it > 'm'}}/${s.length}"
// }
