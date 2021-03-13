fun ranges() {
    println("iterate with ranges")
    for (i in 0..5) {
        print("$i ")
    }
    print("\n")
    for (i in 0 until 3) {
        print("$i ")
    }
    print("\n")
}

fun arrays() {
    println("iterate over array")
    val a = arrayOf(0, 1, 2)
    for (element in a) {
        print("$element")
    }
    print("\n")
}

fun main() {
    ranges()
    arrays()
}