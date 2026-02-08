package fi.joonas.week1tasks.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import fi.joonas.week1tasks.model.Task
import fi.joonas.week1tasks.viewmodel.TaskViewModel

@Composable
fun EditTaskDialog(
    task: Task,
    viewModel: TaskViewModel,
    onDismiss: () -> Unit
) {
    var title by remember { mutableStateOf(task.title) }
    var description by remember { mutableStateOf(task.description) }
    var dueDate by remember { mutableStateOf(task.dueDate ?: "") }

    Dialog(onDismissRequest = onDismiss) {
        Card {
            Column(modifier = Modifier.padding(16.dp)) {

                Text("Edit Task", style = MaterialTheme.typography.titleLarge)

                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Title") }
                )

                OutlinedTextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Description") }
                )

                OutlinedTextField(
                    value = dueDate,
                    onValueChange = { dueDate = it },
                    label = { Text("Due date (YYYY-MM-DD)") }
                )

                Row {

                    TextButton(onClick = {
                        viewModel.removeTask(task.id)
                        onDismiss()
                    }) {
                        Text("Delete")
                    }

                    TextButton(onClick = onDismiss) {
                        Text("Cancel")
                    }

                    TextButton(onClick = {
                        val updated = task.copy(
                            title = title,
                            description = description,
                            dueDate = dueDate
                        )
                        viewModel.updateTask(updated)
                        onDismiss()
                    }) {
                        Text("Save")
                    }
                }
            }
        }
    }
}
