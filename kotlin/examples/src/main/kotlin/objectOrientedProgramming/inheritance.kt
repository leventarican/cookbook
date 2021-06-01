package objectOrientedProgramming

/*
https://play.kotlinlang.org/byExample/01_introduction/07_Inheritance

Kotlin classes are final by default.
For opening a class for inheritance use open modifier.
 */

open class Job {
    open fun description() {
        println("default job")
    }
}

class Developer : Job() {
    override fun description() {
        println("a software developer")
    }
}

fun main() {
    val dev = Developer()
    dev.description()
}