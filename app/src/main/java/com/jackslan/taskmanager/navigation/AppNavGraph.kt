package com.jackslan.taskmanager.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jackslan.taskmanager.presentation.features.home.ui.HomeScreen
import com.jackslan.taskmanager.presentation.features.settings.SettingsScreen

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

        composable(
            route = Screen.SettingsScreen.route
        ) {

            SettingsScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )

        }

    }
}