package com.jackslan.taskmanager.navigation

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home_screen")
    object TaskListScreen : Screen("task_list_screen")
    object CreateEditTaskScreen : Screen("create_edit_task_screen")
    object TaskDetailScreen : Screen("task_detail_screen/{itemId}") {
        fun createRoute(itemId: Int) = "task_detail_screen/$itemId"
    }
    object SettingsScreen : Screen("settings_screen")
}

