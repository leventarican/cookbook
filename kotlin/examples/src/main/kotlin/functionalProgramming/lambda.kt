package functionalProgramming

fun example0(i: Int, count: () -> Long) {
    println("# type of parameter count is: () -> Long; result: ${i + count()}")
}

fun example1(a: () -> Int, b: () -> Int) {
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
}
