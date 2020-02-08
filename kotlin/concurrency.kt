// #############################################################################
// compile and run: kotlinc concurrency.kt && kotlin ConcurrencyKt
// #############################################################################

import kotlin.concurrent.thread

class Thr: Thread() {
    public override fun run() {
        println("Thread: ${Thread.currentThread()}")
    }
}

class Run: Runnable {
    public override fun run() {
        println("Runnable: ${Thread.currentThread()}")
    }
}

fun main(args: Array<String>) {

    // java way
    Thr().start()
    Thread(Run()).start()

    // kotlin extension function for a thread
    thread(start = true) {
        println("Kotlin: ${Thread.currentThread()}")
    }

    // and there are coroutines for asynchronous, non-blocking code
    // you need kotlinx package for that

    // import kotlinx.coroutines.Dispatchers
    // import kotlinx.coroutines.launch

    // launch(Dispatchers.Default) {  
    //     println("${Thread.currentThread()} has run.") 
    // }
}