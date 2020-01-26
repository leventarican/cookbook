// #############################################################################
// compile and run: kotlinc hello.kt && kotlin HelloKt
// #############################################################################

fun foo() = 3
fun bar(): Unit {
    println("bar: 3")
}

fun mutableVariable() {
    var x: Int
    x = 3
    if (true) {
        x = 2
    }
    println("mutableVariable: $x")
}

fun immutableVariable() {
    val x: Int = 3
    println("immutableVariable: $x")
}

// in order to get rid of nullpointerexception
fun nullSafety() {
    var x: String
    x = "null is not possible"

    var y: String?
    y = null

    println(x.length)

    // compile not possible
    // println(y.length)

    // safe access
    println(y?.length)

    try {
        println(y!!.length)        
    }
    catch(e: Exception) {
        println("force nullpointerexception")
    }
}

class FinalClass {
    fun introduce() = println("class is by default final")
}

open class Inheritance() {
    fun introduce() = println("open a class for inheritance")
}

class MoreFeatures : Inheritance() {
    fun feature() = println("i have more features")
}

// before v1.3
// fun main(args: Array<String>) {

// since v1.3
fun main() {
    println("Hello, World!")

    println("foo: ${foo()}")
    bar()

    mutableVariable()
    immutableVariable()

    nullSafety()

    val fc = FinalClass()
    fc.introduce()

    val i = Inheritance()
    i.introduce()

    val mf = MoreFeatures()
    mf.introduce()
    mf.feature()
}