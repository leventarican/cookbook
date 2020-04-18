// #############################################################################
// compile and run: kotlinc objects.kt && kotlin ObjectsKt
// #############################################################################

object Computer {
    val ramUnit: String = "GB"
    fun ram() = 16
    fun whoami() = "an onbject. only 1 instance. even if more threads use it. like a singleton."
}

class SingleBoardComputer {
    val design = "8bit"
    companion object Microprocessor {
        val os = "linux"
    }
}

fun objectDemo() {
    val car = object {
        var brand: String = "Tux"
        var maxVelocity: Int = 300
    }
    println("car: ${car.brand}; velocity ${car.maxVelocity}");
}


fun main(args: Array<String>) {
    println("computer ram: ${Computer.ram()} ${Computer.ramUnit}; whoami: ${Computer.whoami()}")
    objectDemo()

    val computer = SingleBoardComputer()
    println(computer.design)
    println(SingleBoardComputer.Microprocessor.os)
}