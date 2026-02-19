package fi.joonas.week1tasks.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import fi.joonas.week1tasks.viewmodel.TaskViewModel

@Composable
fun AddTaskDialog(
    viewModel: TaskViewModel,
    onDismiss: () -> Unit
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var dueDate by remember { mutableStateOf("") }

    Dialog(onDismissRequest = onDismiss) {
        Card {
            Column(modifier = Modifier.padding(16.dp)) {

                Text("Add Task", style = MaterialTheme.typography.titleLarge)

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
                    TextButton(onClick = onDismiss) {
                        Text("Cancel")
                    }

                    TextButton(onClick = {
                        viewModel.addTask(
                            title = title,
                            description = description,
                            dueDate = dueDate.ifBlank { null }
                        )
                        onDismiss()
                    }) {
                        Text("Save")
                    }
                }
            }
        }
    }
}
