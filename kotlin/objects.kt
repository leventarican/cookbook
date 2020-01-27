// #############################################################################
// compile and run: kotlinc objects.kt && kotlin ObjectsKt
// #############################################################################

// only 1 instance; even if more threads use it. like a singleton.
object Computer {
    val ramUnit: String = "GB"
    fun ram() = 16
}

fun objectDemo() {
    val car = object {
        var brand: String = "Tux"
        var maxVelocity: Int = 300
    }
    println("car: ${car.brand}; velocity ${car.maxVelocity}");
}


fun main(args: Array<String>) {
    println("computer ram: ${Computer.ram()} ${Computer.ramUnit}")
    objectDemo()
}