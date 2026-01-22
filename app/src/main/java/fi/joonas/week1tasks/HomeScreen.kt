package fi.joonas.week1tasks

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import fi.joonas.week1tasks.domain.Task
import java.time.LocalDate

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: TaskViewModel = viewModel()
) {
    val tasks = viewModel.tasks
    var newTitle by remember { mutableStateOf("") }

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

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Button(onClick = { viewModel.filterByDone(true) }) {
                Text("Filter Done")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = { viewModel.clearFilter() }) {
                Text("Show All")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = { viewModel.sortByDueDate() }) {
                Text("Sort by Date")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        LazyColumn {
            items(tasks) { task ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
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
