/*
https://kotlinlang.org/docs/scope-functions.html#function-selection

scope functions: let, run, with, apply, also
 */

class Developer {
    private val programmingLanguages = mutableListOf<String>()
    fun put(language: String) = programmingLanguages.add(language)
    fun code() {
        print("tech stack: ")
        programmingLanguages.forEach {
            print("$it ")
        }
        println()
    }

    fun favouriteLanguage(): String = programmingLanguages.random()
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
}