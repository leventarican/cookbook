open class Computer
class SingleBoard : Computer()
class Cloud<in T>

class Code<out T> (val value: T) {
    init {
        println(value)
    }
}

fun main() {
    var gcp: Cloud<SingleBoard> = Cloud<Computer>()
    var ibm: Cloud<Computer> = Cloud<Computer>()

    // inferred type is Computer but SingleBoard was expected
    // var aws: Cloud<Computer> = Cloud<SingleBoard>()

    var java = Code("java 8")
    var kotlin: Code<Any> = java
    println("kotlin using ${kotlin.value.toString()}")
}
