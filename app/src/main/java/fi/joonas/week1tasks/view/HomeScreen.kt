package fi.joonas.week1tasks.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fi.joonas.week1tasks.model.Task
import fi.joonas.week1tasks.viewmodel.TaskViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: TaskViewModel
) {
    val tasks by viewModel.tasks.collectAsState()

    // Dialogien tilat
    var showAddDialog by remember { mutableStateOf(false) }
    var taskToEdit by remember { mutableStateOf<Task?>(null) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { showAddDialog = true }) {
                Icon(Icons.Default.Add, contentDescription = "Add task")
            }
        }
    ) { padding ->

        Column(modifier = modifier.padding(padding).padding(16.dp)) {

            Text(
                text = "Task List",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(tasks.size) { index ->
                    val task = tasks[index]

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp)
                            .clickable { taskToEdit = task },
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
    }

    // ADD DIALOG
    if (showAddDialog) {
        AddTaskDialog(
            viewModel = viewModel,
            onDismiss = { showAddDialog = false }
        )
    }

    // EDIT DIALOG
    taskToEdit?.let { task ->
        EditTaskDialog(
            task = task,
            viewModel = viewModel,
            onDismiss = { taskToEdit = null }
        )
    }
}
