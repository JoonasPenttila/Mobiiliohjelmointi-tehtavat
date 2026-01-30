package fi.joonas.week1tasks.domain

import fi.joonas.week1tasks.model.Task

// Lisää uusi task listan perään
fun addTask(list: List<Task>, task: Task): List<Task> {
    return list + task
}

// Kääntää done-tilan TRUE <-> FALSE
fun toggleDone(list: List<Task>, id: Int): List<Task> {
    return list.map { task ->
        if (task.id == id) task.copy(done = !task.done) else task
    }
}

// Suodattaa listan done-tilan mukaan
fun filterByDone(list: List<Task>, done: Boolean): List<Task> {
    return list.filter { it.done == done }
}

// Sorttaa listan eräpäivän mukaan
fun sortByDueDate(list: List<Task>): List<Task> {
    return list.sortedBy { it.dueDate }
}
