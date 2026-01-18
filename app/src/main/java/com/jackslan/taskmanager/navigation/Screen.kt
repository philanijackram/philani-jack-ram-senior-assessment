package com.jackslan.taskmanager.navigation

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home_screen")
    object SettingsScreen : Screen("settings_screen")
}

