//https://www.codewars.com/kata/554e4a2f232cdd87d9000038/train/kotlin

fun makeComplement(dna: String): String {
    val solution = dna.map { s ->
        when (s) {
            'A' -> 'T'
            'T' -> 'A'
            'C' -> 'G'
            'G' -> 'C'
            else -> println("nothing to map")
        }
    }.joinToString("")
    println(solution)
    return solution
}

fun main() {
    val a = "TTTT"
    val b = "TAACG"
    makeComplement(b)
}

//fun makeComplement(dna : String) : String = dna.map { it.complement() }.joinToString("")
//fun Char.complement() = when(this) {
//    'A' -> 'T'
//    'T' -> 'A'
//    'C' -> 'G'
//    'G' -> 'C'
//    else -> this
//}

//fun makeComplement(dna: String) = dna.replace("A","t").replace("T","a").replace("C", "g").replace("G","c").toUpperCase()
