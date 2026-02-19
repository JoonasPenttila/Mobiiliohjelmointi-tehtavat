package fi.joonas.week1tasks.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import fi.joonas.week1tasks.data.local.AppDatabase
import fi.joonas.week1tasks.data.repository.TaskRepository
import fi.joonas.week1tasks.ui.theme.Week1Theme
import fi.joonas.week1tasks.viewmodel.TaskViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "tasks.db"
        ).build()

        val repository = TaskRepository(db.taskDao())
        val viewModel = TaskViewModel(repository)

        setContent {
            Week1Theme {
                val navController = rememberNavController()

                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(navController)
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = ROUTE_HOME,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(ROUTE_HOME) {
                            HomeScreen(viewModel = viewModel)
                        }
                        composable(ROUTE_CALENDAR) {
                            CalendarScreen(viewModel = viewModel)
                        }
                        composable(ROUTE_SETTINGS) {
                            SettingsScreen()
                        }
                    }
                }
            }
        }
    }
}
