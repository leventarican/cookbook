package dojo

/*
https://www.codewars.com/kata/55a70521798b14d4750000a4/train/kotlin

Make a function that will return a greeting statement that uses an input;
your program should return, "Hello, <name> how are you doing today?".
 */

fun greet(name: String) = "Hello, $name how are you doing today?"

fun main() {
    println(greet("kotlin"))
}