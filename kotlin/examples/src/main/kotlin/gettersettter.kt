/**
 * create custom getter and setter aka properties
 */

class Properties() {
    var property: Int = 5
    set(value) {
        if (value in (0..10)) {
            field = value
        }
    }
    get() {
        return field.plus(1)
    }
}


fun main() {
    val a = Properties()
    a.property = 100
    println(a.property)
}