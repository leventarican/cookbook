package objectOrientedProgramming

object Singleton {
    fun code0() = 100
    fun code1() {
        println("singleton (object example) ${code0()}")
    }
}

open class A(x: Int) {
    public open val y: Int = x
    public fun dataA() = "payload A"
}

interface B { /*...*/ }

val ab: A = object : A(1), B {
    override val y = 15
}

class Android {
    private val activity : String = "Activity"
    private val contentProvider : String = "Content Provider"
    private val intent : String = "Intent"
    fun sendData(payload: DataJava) {
        println("$intent# sending data: $payload")
    }
}

fun main() {
    val a = object : DataJava("payload") {}
    val b = object : DataJava("payload") {}
    val c = DataJava("payload")
    println(a)
    println(b)
    println(c)

    val d = object {
        val payload = "object keyword extends Any"
        override fun toString() = "anonymous object: $payload"
    }
    println(d)

    val e = object : A(100), B {
        fun dataB() = "payload B"
    }
    println(e.dataA())
    println(e.dataB())

    val f = Android()
    f.sendData(object : DataJava("0xF1") {
        override fun toString(): String {
            return "${super.toString()} | [inheriting anonymous objects from supertypes]"
        }
    })
    f.sendData(DataJava("0x1F"))
}