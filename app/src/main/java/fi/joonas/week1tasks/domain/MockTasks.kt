package fi.joonas.week1tasks.domain

import fi.joonas.week1tasks.model.Task

val mockTasks = listOf(
    Task(
        id = 1,
        title = "Example task 1",
        description = "Description 1",
        priority = 1,
        dueDate = "2026-02-10",
        done = false
    ),
    Task(
        id = 2,
        title = "Example task 2",
        description = "Description 2",
        priority = 2,
        dueDate = "2026-02-12",
        done = false
    ),
    Task(
        id = 3,
        title = "Example task 3",
        description = "Description 3",
        priority = 3,
        dueDate = "2026-02-15",
        done = true
    )
)
