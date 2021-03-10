
data class Developer(val programmingLanguage: String, val experience: Int)

class Application(val developer: Developer?) {
    fun code() {
        println("Developer coding in ${developer?.programmingLanguage}")
    }
}

fun getJavaDeveloper(developers: List<Developer>?): Developer? {
    return if (developers == null || developers.isEmpty()) {
        Developer("java", 0)
    } else {
        developers.filter {
            it.programmingLanguage == "java"
        }.firstOrNull()
    }
}

fun main() {
    val developers = listOf(
        Developer("kotlin", 10),
        Developer("rust", 30),
        Developer("java", 40),
        Developer("python", 20)
    )

    val javaDeveloper = getJavaDeveloper(developers)
    Application(javaDeveloper).code()
}
