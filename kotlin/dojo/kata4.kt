// https://www.codewars.com/kata/59cfc000aeb2844d16000075/train/kotlin

fun capitalize(text: String): List<String> {
    val a: MutableList<Char> = mutableListOf()
    for (i in 0..text.length-1) {
        var c = text[i]
        if (i%2==0) {
            a.add(c.toUpperCase())
        } else {
            a.add(c)
        }
    }
    val b: MutableList<Char> = mutableListOf()
    for (i in 0..text.length-1) {
        var c = text[i]
        if (i%2==0) {
            b.add(c)
        } else {
            b.add(c.toUpperCase())
        }
    }

    val x = a.toList().joinToString("")
    val y = b.toList().joinToString("")

    println(x)
    println(y)

    return listOf(x, y)
}

fun main(args: Array<String>) {
    val text = "codewars"   // listOf("CoDeWaRs", "cOdEwArS")
    capitalize(text)
}

// fun capitalize(text: String): List<String> =
//     listOf(
//         text.mapIndexed { index, c -> if (index % 2 == 0) c.toUpperCase() else c }.joinToString(""),
//         text.mapIndexed { index, c -> if (index % 2 == 1) c.toUpperCase() else c }.joinToString("")
//     )