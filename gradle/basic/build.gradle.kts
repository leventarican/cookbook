println("configuration phase.")

// define detault tasks
defaultTasks("hello")

tasks.register("hello") {
    println("execution phase: HELLO")
    println("configuration phase, if run with :hello")
}

tasks.register("code") {
    // task code depends on task line. task line will also be executed on gradle code
    dependsOn("line")

    doLast {
        val lang = "kotlin"
        println("using programming language: ${lang.toUpperCase()}")
    }
}

tasks.register("line") {
    repeat(80) { print("#") }
    println()
}