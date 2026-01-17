package com.jackslan.taskmanager.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.jackslan.taskmanager.presentation.features.create_edit_task.CreateEditTaskScreen
import com.jackslan.taskmanager.presentation.features.home.HomeScreen
import com.jackslan.taskmanager.presentation.features.settings.SettingsScreen
import com.jackslan.taskmanager.presentation.features.task_details.TaskDetailScreen
import com.jackslan.taskmanager.presentation.features.task_list.TaskListScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(route = Screen.HomeScreen.route) {

            HomeScreen(
                onSettingsClick = {
                    navController.navigate(Screen.SettingsScreen.route)
                }
            )

        }

        composable(route = Screen.TaskListScreen.route) {
            Scaffold() { paddingValues ->
                TaskListScreen(
                    modifier = Modifier.padding(paddingValues),
                    onCreateClick = {
                        navController.navigate(Screen.CreateEditTaskScreen.route)
                    },
                    onItemClick = {
                        navController.navigate(Screen.TaskDetailScreen.createRoute(1))
                    }
                )
            }
        }

        composable(route = Screen.CreateEditTaskScreen.route) {
            Scaffold() { paddingValues ->
                CreateEditTaskScreen(
                    modifier = Modifier.padding(paddingValues),
                )
            }
        }

        composable(
            route = Screen.TaskDetailScreen.route,
            arguments = listOf(navArgument("itemId") { type = NavType.IntType })
        ) {
            Scaffold() { paddingValues ->
                TaskDetailScreen(
                    modifier = Modifier.padding(paddingValues),
                )
            }
        }

        composable(
            route = Screen.SettingsScreen.route
        ) {
            Scaffold() { paddingValues ->
                SettingsScreen(modifier = Modifier.padding(paddingValues))
            }
        }

    }
}