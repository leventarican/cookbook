
fun main() {
    generateSequence(0) { it + 1 }.windowed(size=3, step=10)
    .take(3).toList()
    .apply(::println)

    // [[0, 1, 2], [10, 11, 12], [20, 21, 22]]
}