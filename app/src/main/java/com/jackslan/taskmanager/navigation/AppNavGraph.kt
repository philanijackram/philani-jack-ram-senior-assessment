package com.jackslan.taskmanager.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jackslan.taskmanager.presentation.features.home.ui.HomeScreen
import com.jackslan.taskmanager.presentation.features.settings.ui.SettingsScreen
import com.jackslan.taskmanager.presentation.features.splash_screen.SplashScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {

        composable(route = Screen.SplashScreen.route) {

            SplashScreen(
                modifier = Modifier.fillMaxSize(),
                onNavigateToHome = {
                    navController.navigate(Screen.HomeScreen.route)
                }
            )

        }

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