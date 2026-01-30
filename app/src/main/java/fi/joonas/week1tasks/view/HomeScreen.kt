package fi.joonas.week1tasks.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import fi.joonas.week1tasks.model.Task
import fi.joonas.week1tasks.viewmodel.TaskViewModel
import java.time.LocalDate

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: TaskViewModel = viewModel()
) {
    val tasks by viewModel.tasks.collectAsState()

    var newTitle by remember { mutableStateOf("") }
    var selectedTask by remember { mutableStateOf<Task?>(null) }

    Column(modifier = modifier.padding(16.dp)) {

        Text(
            text = "Task List",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            TextField(
                value = newTitle,
                onValueChange = { newTitle = it },
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = {
                if (newTitle.isNotBlank()) {
                    val newTask = Task(
                        id = tasks.size + 1,
                        title = newTitle,
                        description = "Lisätty napista",
                        priority = 1,
                        dueDate = LocalDate.now().plusDays(7),
                        done = false
                    )
                    viewModel.addTask(newTask)
                    newTitle = ""
                }
            }) {
                Text("Add")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        LazyColumn {
            items(tasks.size) { index ->
                val task = tasks[index]

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                        .clickable { selectedTask = task },
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row {
                        Checkbox(
                            checked = task.done,
                            onCheckedChange = { viewModel.toggleDone(task.id) }
                        )
                        Column {
                            Text(task.title)
                            Text(task.dueDate.toString())
                        }
                    }

                    Button(onClick = { viewModel.removeTask(task.id) }) {
                        Text("X")
                    }
                }
            }
        }
    }

    if (selectedTask != null) {
        DetailDialog(
            task = selectedTask!!,
            onDismiss = { selectedTask = null },
            onSave = { updated ->
                viewModel.updateTask(updated)
                selectedTask = null
            },
            onDelete = { id ->
                viewModel.removeTask(id)
                selectedTask = null
            }
        )
    }
}
