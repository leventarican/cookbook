package objectOrientedProgramming

class ClassInitialization0(val payload: String)

/**
 * same like example 0
 *
 * with primary constructor and initialization block
 */
class ClassInitialization1 constructor(_payload: String) {
    val payload: String
    init {
        payload = _payload
    }

    init {
        println("init data")
    }

    init {
        println("some other init tasks")
    }
}

/**
 * same like example 1
 */
class ClassInitialization2 constructor(_payload: String) {
    val payload: String = _payload
}