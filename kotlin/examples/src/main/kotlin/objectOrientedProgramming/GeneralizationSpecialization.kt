package objectOrientedProgramming

/**
 * demo of: generalization, specialization, polymorphism
 */

// whoami feature is used by both classes to extract this to a superclass
internal open class Generalization constructor(private val payload: String) {
    fun whoami() {
        println("payload. $payload")
    }
}

// examples specialization classes
internal class SuperclassUser : Generalization("superclass user")
internal class Specialization : Generalization("another superclass user (aka specialization).") {
    fun expert() {
        println("i have an expert feature implemented")
    }
}

fun main() {
    val a = SuperclassUser() as Generalization
    val b = Specialization()

    val polymorphism = listOf<Generalization>(a, b)

    polymorphism.forEach {
        it.whoami()
    }

    if (b is Generalization) {
        b.expert()
    }
}