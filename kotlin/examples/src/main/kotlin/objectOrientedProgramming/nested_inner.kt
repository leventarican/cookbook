package objectOrientedProgramming

class Computer {
    private val components: List<Component>
    init {
        components = listOf(Case(), Motherboard(), Processor(), Memory(), HardDrive(), PowerSupply())
    }
    abstract class Component {
        abstract fun description()
    }
    class Case : Component() {
        override fun description() { println("case: aluminium") }
    }
    class Motherboard : Component() {
        override fun description() { println("motherboard: atx") }
    }
    class Processor : Component() {
        override fun description() { println("cpu: 4x cores") }
    }
    class Memory : Component() {
        override fun description() { println("memory: 16GB") }
    }
    class HardDrive : Component() {
        override fun description() { println("disc: 1TB SSD") }
    }
    class PowerSupply : Component() {
        fun on() { println("computer power on.") }
        override fun description() { println("power: 400 Watt") }
    }
    fun run() {
        components.forEach { it.description() }
        components.forEach {
            if (it is PowerSupply) it.on()
        }
    }
}

fun main() {
    val computer = Computer()
    computer.run()
}