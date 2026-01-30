package fi.joonas.week1tasks.model

import java.time.LocalDate

data class Task(
    val id: Int,
    val title: String,
    val description: String,
    val priority: Int,
    val dueDate: LocalDate,
    val done: Boolean
)