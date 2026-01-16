package com.jackslan.taskmanager.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.jackslan.taskmanager.presentation.features.create_edit_task.CreateEditTaskScreen
import com.jackslan.taskmanager.presentation.features.home.HomeScreen
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
                modifier = Modifier,
                onToDoClick = {
                    navController.navigate(Screen.TaskListScreen.route)
                },
                onCompletedClick = {
                    navController.navigate(Screen.TaskListScreen.route)
                }
            )
        }

        composable(route = Screen.TaskListScreen.route) {
            TaskListScreen(
                onCreateClick = {
                    navController.navigate(Screen.CreateEditTaskScreen.route)
                },
                onItemClick = {
                    navController.navigate(Screen.TaskDetailScreen.createRoute(1))
                }
            )
        }

        composable(route = Screen.CreateEditTaskScreen.route) {
            CreateEditTaskScreen()
        }

        composable(
            route = Screen.TaskDetailScreen.route,
            arguments = listOf(navArgument("itemId") { type = NavType.IntType })
        ) {
            TaskDetailScreen()
        }

    }
}