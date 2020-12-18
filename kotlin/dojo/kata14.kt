// you have a concatened string of urls from open tabs in firefox
// bring it to an readable format

// in: www.firefox.com|www.codewars.com|www.github.com
// out:
// www.firefox.com
// www.codewars.com
// www.github.com

import java.io.*

fun main() {
    File("data.txt").forEachLine {
        it.split("|").forEach {
            println(it)
        }
    }
}
