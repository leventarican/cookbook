// #############################################################################
// compile and run: kotlinc classes.kt && kotlin ClassesKt
// #############################################################################

class FinalClass {
    fun introduce() = println("class is by default final")
}

open class Inheritance() {
    fun introduce() = println("open a class for inheritance")
}

class MoreFeatures : Inheritance() {
    fun feature() = println("i have more features")
}

// primary constructor
// initializer block
class Computer(ram: Int, batteryLifetimeInH: Int) {
    val keyFeature = "ram: $ram; battery lifetime [h]: $batteryLifetimeInH"
    var developerReady: Boolean

    init {
        developerReady = if (ram >= 16) true else false
    }

    override fun toString(): String {
        return """
class Computer
--------------
this is a demo for primary constructor and init block.
instance description
    key feature: $keyFeature
    developer ready: $developerReady
        """
    }
}

// secondary constructors
class Code {
    var p: String
    constructor(programmingLanguage: String) {
        p = programmingLanguage
    }
    constructor():this("kotlin")
    override fun toString(): String {
        return """
class Code
--------------
this is a demo for secondary constructors.
programming language: $p
        """
    }    
}

class CodeComputer(ram: Int, batteryLifetimeInH: Int) {
    val description = "ram: $ram; battery [h]: batteryLifetimeInH"
    constructor(ram: Int):this(ram, 10)
    override fun toString(): String {
        return description
    }
}

fun main() {
    val fc = FinalClass()
    fc.introduce()

    val i = Inheritance()
    i.introduce()

    val mf = MoreFeatures()
    mf.introduce()
    mf.feature()

    val computer = Computer(16, 24)
    println(computer)

    val code = Code()
    println(code)
    println(Code("java"))

    val cc = CodeComputer(16)
    println(cc)   
}