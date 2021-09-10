
fun init() = "CODE"

private fun main() {
    var a: String? = null
    var b: String = "DEFAULT"
    val c: String by lazy { init() }

    // ...
    b = init()
    a = b

    println(a)
    println(b)
    println(c)
}