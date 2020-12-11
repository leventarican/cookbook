// https://www.codewars.com/kata/5700c9acc1555755be00027e/train/kotlin

/*
https://en.wikipedia.org/wiki/String_(computer_science)#Rotations

the string abc has three different rotations, viz. 
abc itself (with u=abc, v=ε), bca (with u=bc, v=a), and cab (with u=c, v=ab). 
*/
fun containAllRots(strng:String, arr:ArrayList<String>):Boolean {
    val rotations = strng.length
    println("string has $rotations rotations")

    strng.forEachIndexed {
        k, _ -> run {
            val s = strng.substring(k+1..rotations-1) + strng.substring(0..k)
            val i = s in arr
            println("$s in array: ${i}")
            if (i == false) return false
        }
    }

    return true
}

fun main() {
    var a = arrayListOf("bsjq", "qbsj", "sjqb", "twZNsslC", "jqbs")
    containAllRots("bsjq", a)
}

// return arr.containsAll(List(strng.length) { (strng.drop(it) + strng.take(it)) })
