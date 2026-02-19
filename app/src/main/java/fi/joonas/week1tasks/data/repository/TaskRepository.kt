package fi.joonas.week1tasks.data.repository

import fi.joonas.week1tasks.data.local.TaskDao
import fi.joonas.week1tasks.data.model.TaskEntity

class TaskRepository(private val dao: TaskDao) {

    val tasks = dao.getTasks()

    suspend fun add(task: TaskEntity) = dao.insert(task)

    suspend fun update(task: TaskEntity) = dao.update(task)

    suspend fun delete(task: TaskEntity) = dao.delete(task)
}
