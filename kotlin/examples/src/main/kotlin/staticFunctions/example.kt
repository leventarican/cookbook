package staticFunctions

fun packageLevel() {
    println("package level function in kotlin. " +
            "use it as a replacement of java static functions.")
}
/*
this will compile to (tools > kotlin > show kotlin bytcode

public final class ExampleKt {
   public static final void packageLevel() {
   ...
 */

// the java old-style. check also javaInteroperability package
class JavaStyle {
    companion object {
        fun staticFunction() {
            println("call from java with JavaStyle.Companion.staticFunction()")
        }

        @JvmStatic
        fun javaFriendly() {
            println("with @JvmStatic its callable from java with JavaStyle.staticFunction()")
        }
    }
}