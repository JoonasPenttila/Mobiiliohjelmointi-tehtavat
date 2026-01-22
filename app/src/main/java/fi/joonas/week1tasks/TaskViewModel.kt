package fi.joonas.week1tasks

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import java.time.LocalDate
import fi.joonas.week1tasks.domain.Task

class TaskViewModel : ViewModel() {

    private var originalTasks = listOf<Task>()

    var tasks by mutableStateOf(listOf<Task>())
        private set

    init {
        originalTasks = listOf(
            Task(1, "Buy milk", "From store", 1, LocalDate.now(), false),
            Task(2, "Clean room", "Vacuum", 2, LocalDate.now().plusDays(1), true),
            Task(3, "Do homework", "Math", 3, LocalDate.now().plusDays(2), false)
        )
        tasks = originalTasks
    }

    fun addTask(task: Task) {
        originalTasks = originalTasks + task
        tasks = originalTasks
    }

    fun toggleDone(id: Int) {
        originalTasks = originalTasks.map { t ->
            if (t.id == id) t.copy(done = !t.done) else t
        }
        tasks = originalTasks
    }

    fun removeTask(id: Int) {
        originalTasks = originalTasks.filter { it.id != id }
        tasks = originalTasks
    }

    fun filterByDone(done: Boolean) {
        tasks = originalTasks.filter { it.done == done }
    }

    fun clearFilter() {
        tasks = originalTasks
    }

    fun sortByDueDate() {
        tasks = tasks.sortedBy { it.dueDate }
    }
}
