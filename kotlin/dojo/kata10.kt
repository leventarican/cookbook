// https://www.codewars.com/kata/554a44516729e4d80b000012/train/kotlin

/*
old car: 2000
new car: 8000
save each month: 1000
decrease per 1 month: 1.5
increase percentage loss per 2 month: 0.5

how many month will it take to save enough money to buy the new car?

end month 1: percentLoss 1.5 available -4910.0
end month 2: percentLoss 2.0 available -3791.7999...
end month 3: percentLoss 2.0 available -2675.964
end month 4: percentLoss 2.5 available -1534.06489...
end month 5: percentLoss 2.5 available -395.71327...
end month 6: percentLoss 3.0 available 766.158120825...
return [6, 766] or (6, 766)
*/

import kotlin.math.roundToInt

fun nbMonths(
    startPriceOld: Int,
    startPriceNew: Int,
    savingperMonth: Int,
    percentLossByMonth: Double
): Pair<Int, Int> {
    println("# $startPriceOld; $startPriceNew; $savingperMonth; $percentLossByMonth")

    // edge case
    if (startPriceOld >= startPriceNew) {
        val solution = Pair(0, startPriceOld - startPriceNew)
        println(solution)
        return solution
    }

    var l = percentLossByMonth / 100.0
    var o : Double = startPriceOld / 1.0
    var n : Double = startPriceNew / 1.0
    var m = 0
    var a = 0.0
    for (i in 1..36) {
        if (i%2 == 0) {
            println(i)
            l = l + 0.005
        }
        o = o - o*l
        n = n - n*l
        a = (o + savingperMonth*i) - n
        println("month: $i; loss: $l; available: $a")
        if (a > 0) {
            m = i
            break
        }
    }

    var solution = Pair(m, a.roundToInt())
    println(solution)
    return solution
}

fun main() {
    // nbMonths(2000, 8000, 1000, 1.5) // Pair(6, 766)
    // nbMonths(12000, 8000, 1000, 1.5) // Pair(0, 4000)
    // nbMonths(7500, 32000, 300, 1.55) // Pair(25, 122)
    nbMonths(2900, 2900, 1000, 1.3) // Pair(0, 0)
}
