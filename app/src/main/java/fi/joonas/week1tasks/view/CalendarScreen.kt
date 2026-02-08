package fi.joonas.week1tasks.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fi.joonas.week1tasks.model.Task
import fi.joonas.week1tasks.viewmodel.TaskViewModel

@Composable
fun CalendarScreen(viewModel: TaskViewModel) {

    val tasks by viewModel.tasks.collectAsState()
    var taskToEdit by remember { mutableStateOf<Task?>(null) }

    val grouped = tasks.groupBy { it.dueDate ?: "Ei päivää" }

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        grouped.forEach { (date, tasksForDay) ->

            item {
                Text(
                    text = date,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            items(tasksForDay) { task ->
                Card(
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .clickable { taskToEdit = task }
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(task.title, style = MaterialTheme.typography.titleMedium)
                        Text(task.description)
                    }
                }
            }
        }
    }

    taskToEdit?.let { task ->
        EditTaskDialog(
            task = task,
            viewModel = viewModel,
            onDismiss = { taskToEdit = null }
        )
    }
}
