package functionalProgramming

private fun example0() {
    val a = 1
    val b = 2

    // no need for parameter definition
    // we have access to a and b because they are scope
    val c: () -> Int
    c = {
        a + b
    }

    val x = c()
    println("# closure example: $x")
}

private fun example1() {
    var requirementFulfilled = true

    val implement: () -> Unit = {
        if (requirementFulfilled) {
            println("# implementing requirement")
        }
    }

    implement()
    requirementFulfilled = false
    implement()

    // output only once because variable value changed !!
    // # implementing requirement
}

fun main() {
    example0()
    example1()
}