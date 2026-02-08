package fi.joonas.week1tasks.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fi.joonas.week1tasks.ui.theme.Week1Theme
import fi.joonas.week1tasks.viewmodel.TaskViewModel
import fi.joonas.week1tasks.view.CalendarScreen
import fi.joonas.week1tasks.view.HomeScreen
import fi.joonas.week1tasks.view.SettingsScreen
import fi.joonas.week1tasks.view.BottomNavigationBar
import fi.joonas.week1tasks.view.ROUTE_HOME
import fi.joonas.week1tasks.view.ROUTE_CALENDAR
import fi.joonas.week1tasks.view.ROUTE_SETTINGS

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Week1Theme {
                val navController = rememberNavController()
                val viewModel: TaskViewModel = viewModel()

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
