package fi.joonas.week1tasks.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fi.joonas.week1tasks.data.model.TaskEntity
import fi.joonas.week1tasks.data.repository.TaskRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TaskViewModel(
    private val repository: TaskRepository
) : ViewModel() {

    val tasks: StateFlow<List<TaskEntity>> =
        repository.tasks.stateIn(
            viewModelScope,
            SharingStarted.Lazily,
            emptyList()
        )

    fun addTask(title: String, description: String, dueDate: String?) {
        viewModelScope.launch {
            repository.add(
                TaskEntity(
                    title = title,
                    description = description,
                    priority = 1,
                    dueDate = dueDate,
                    done = false
                )
            )
        }
    }

    fun updateTask(task: TaskEntity) {
        viewModelScope.launch {
            repository.update(task)
        }
    }

    fun removeTask(task: TaskEntity) {
        viewModelScope.launch {
            repository.delete(task)
        }
    }

    fun toggleDone(task: TaskEntity) {
        viewModelScope.launch {
            repository.update(task.copy(done = !task.done))
        }
    }
}
