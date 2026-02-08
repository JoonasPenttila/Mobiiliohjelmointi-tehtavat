package fi.joonas.week1tasks.view

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Settings

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar {
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate(ROUTE_HOME) },
            label = { Text("Home") },
            icon = { Icon(Icons.Default.List, contentDescription = null) }
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate(ROUTE_CALENDAR) },
            label = { Text("Calendar") },
            icon = { Icon(Icons.Default.DateRange, contentDescription = null) }
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate(ROUTE_SETTINGS) },
            label = { Text("Settings") },
            icon = { Icon(Icons.Default.Settings, contentDescription = null) }
        )
    }
}
