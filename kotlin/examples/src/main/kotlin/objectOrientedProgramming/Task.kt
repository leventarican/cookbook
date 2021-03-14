package objectOrientedProgramming

enum class Status {
    OPEN,
    IN_PROGRESS,
    DONE
}

class Task(status: Status) {
    private var status: Status = status
    var description: String? = null
        get() {
            return when (status) {
                Status.IN_PROGRESS -> "# task in progress"
                Status.DONE -> "# task done"
                else -> "# task open"
            }
        }

}

fun main() {
    val task: Task = Task(Status.IN_PROGRESS)
    println(task.description)
}