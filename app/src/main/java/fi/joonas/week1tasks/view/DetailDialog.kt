package fi.joonas.week1tasks.view

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.window.Dialog
import fi.joonas.week1tasks.model.Task
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog


@Composable
fun DetailDialog(
    task: Task,
    onDismiss: () -> Unit,
    onSave: (Task) -> Unit,
    onDelete: (Int) -> Unit
) {
    var title by remember { mutableStateOf(task.title) }
    var description by remember { mutableStateOf(task.description) }

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = MaterialTheme.shapes.medium,
            tonalElevation = 4.dp
        ) {
            Column(modifier = androidx.compose.ui.Modifier.padding(16.dp)) {

                Text("Edit Task", style = MaterialTheme.typography.headlineSmall)

                Spacer(modifier = androidx.compose.ui.Modifier.height(12.dp))

                TextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Title") }
                )

                Spacer(modifier = androidx.compose.ui.Modifier.height(12.dp))

                TextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Description") }
                )

                Spacer(modifier = androidx.compose.ui.Modifier.height(20.dp))

                Row {
                    Button(
                        onClick = {
                            onSave(task.copy(title = title, description = description))
                        }
                    ) {
                        Text("Save")
                    }

                    Spacer(modifier = androidx.compose.ui.Modifier.width(8.dp))

                    Button(
                        onClick = { onDelete(task.id) },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.error
                        )
                    ) {
                        Text("Delete")
                    }

                    Spacer(modifier = androidx.compose.ui.Modifier.width(8.dp))

                    OutlinedButton(onClick = onDismiss) {
                        Text("Cancel")
                    }
                }
            }
        }
    }
}
