// #############################################################################
// compile and run: kotlinc classes.kt && kotlin ClassesKt
// #############################################################################

import kotlin.reflect.KProperty

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

class Properties {
    val field: String = "a field"

    // property: a private field with getter / setter
    var id: Int = 0
    get() = field
    set(value) {
        field = value + 100
        println("setting id to: $id")
    }

    private val _backing: String = "backing field with underscore"
    val backing: String 
    get() {
        return _backing
    }

    val print = {
        println("access _backing: $_backing")
    }

    var del: String by Delegated()
}

class Delegated {
    // operator function: using . operator
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "getting: $thisRef"
    }
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("setting $thisRef to $value")
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

    val p = Properties()
    println("${p.field}")
    println("${p.id}")
    p.id = 2
    p.print()
    println(p.del)
    p.del = "works"
}