package objectOrientedProgramming

sealed class SealedClass
sealed interface SealedInterface

class ImplSealedClass : SealedClass() {
    val payload : String
    init {
        payload = "sealed class is abstract"
    }
    override fun toString() = "# $payload"
}