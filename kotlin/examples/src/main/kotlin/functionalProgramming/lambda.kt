package functionalProgramming

private fun example0(i: Int, count: () -> Long) {
    println("# type of parameter count is: () -> Long; result: ${i + count()}")
}

private fun example1(a: () -> Int, b: () -> Int) {
    println("# a: ${a()}; b: ${b()}")
}

fun main() {
    example0(100) {
        1 + 1000.toLong()
    }

    example1({
        10
    }, {
        20
    })

    val example2 = { x: Int -> x * 2 }
    println("# ${example2(2)}")

    val example3: (Int) -> Int = { i -> i * 3 }
    println("# ${example3(2)}")

    val example4: () -> Unit = {
        println("# variable with type: () -> Unit")
    }
    example4()

    val example5: (String, String) -> String = { x, y -> "$x$y"}
    val concat = example5("kot", "lin")
    println("# $concat")

    // with function pointers ::
    val example6: (String) -> String = String::toUpperCase
    println(example6("kotlin"))
}
