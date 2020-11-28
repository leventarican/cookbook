// https://www.codewars.com/kata/555086d53eac039a2a000083/train/kotlin

fun loveFun(flowerA: Int, flowerB: Int): Boolean {
    var a = (flowerA%2==0) and (flowerB%2!=0)
    var b = (flowerA%2!=0) and (flowerB%2==0)
    return a or b;
}

fun main() {
    println(loveFun(1, 4))
}
