/*
https://kotlinlang.org/docs/scope-functions.html#function-selection

scope functions: let, run, with, apply, also
 */

class Developer {
    private val programmingLanguages = mutableListOf<String>()
    val numberOfProgrammingLanguages = programmingLanguages.size
    fun put(language: String) = programmingLanguages.add(language)
    fun code() {
        print("tech stack: ")
        programmingLanguages.forEach {
            print("$it; ")
        }
        println()
    }

    fun favouriteLanguage(): String = programmingLanguages.random()
}

fun randomPassword(length: Int): String =
    with('a' until 'l' ) {
        return toList().shuffled().subList(0, length).joinToString("")
    }

fun main() {
    val d = Developer()
    d.apply {
        put("kotlin")
        put("java")
        put("rust")
    }.code()
    val f = d.favouriteLanguage()
    println(f)

    f.run { println("run (object reference = this): $length") }
    f.let { println("let (object reference = it): ${it.length}") }

    val a = with(10) {
        val a = (0..this).toList()
        println(a)
        a.reversed()
    }.joinToString { "$it" }
    println(a)

    val g: String? = null
    val h = g.let {
        println("processing")
        it ?: "default"
    }
    println(h)

    d.run {
        put("scope function: run")
    }
    d.let {
        it.put("scope function: let")
    }

    with(d) {
        println("$numberOfProgrammingLanguages")
        // instead of d.numberOfProgrammingLanguages
    }

    d.apply {
        put("scope function: apply")
    }.code()

    println(randomPassword(10))
}