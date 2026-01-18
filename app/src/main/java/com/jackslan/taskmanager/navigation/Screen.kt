package com.jackslan.taskmanager.navigation

sealed class Screen(val route: String) {
    object SplashScreen : Screen("Splash_screen")
    object HomeScreen : Screen("home_screen")
    object SettingsScreen : Screen("settings_screen")
}

