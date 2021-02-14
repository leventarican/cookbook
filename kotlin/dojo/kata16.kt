/* delegation pattern: kotlin by keyword example */

interface ProgrammingLanguage {
    fun version()
    fun compile() {
        println("compiling")
    }
}

class Java : ProgrammingLanguage {
    override fun version() {
        println("java 15")
    }
}

class Rust : ProgrammingLanguage {
    override fun version() = println("rustc 1.49.0")
}

// Composition
class Boilerplate(val pl: ProgrammingLanguage) {
    fun delegate() {
        pl.version()
    }
}

// no boilerplate code
class Pattern(val pl: ProgrammingLanguage): ProgrammingLanguage by pl

fun main() {
    val j = Java().also {
        it.version()
    }
    val r = Rust().also {
        it.version()
    }

    Boilerplate(j).also {
        it.delegate()
    }
    Boilerplate(r).also {
        it.delegate()
    }

    Pattern(j).also {
        it.version()
    }
    Pattern(r).also {
        it.version()
    }
}
