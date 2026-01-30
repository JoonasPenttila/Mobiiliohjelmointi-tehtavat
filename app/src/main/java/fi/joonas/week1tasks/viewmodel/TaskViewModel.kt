package fi.joonas.week1tasks.viewmodel

import androidx.lifecycle.ViewModel
import fi.joonas.week1tasks.model.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TaskViewModel : ViewModel() {

    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks

    fun addTask(task: Task) {
        _tasks.value = _tasks.value + task
    }

    fun toggleDone(taskId: Int) {
        _tasks.value = _tasks.value.map {
            if (it.id == taskId) it.copy(done = !it.done) else it
        }
    }

    fun removeTask(taskId: Int) {
        _tasks.value = _tasks.value.filterNot { it.id == taskId }
    }

    fun updateTask(updated: Task) {
        _tasks.value = _tasks.value.map {
            if (it.id == updated.id) updated else it
        }
    }
}
