package com.jackslan.taskmanager.presentation.features.home.state

import com.jackslan.taskmanager.domain.model.TaskItem

sealed class HomeEffect {
    object LoadTasks : HomeEffect()
    data class ShowError(val message: String) : HomeEffect()
    data class ShowTaskDetailsDialog(val taskItem: TaskItem) : HomeEffect()
    object ShowCreateTaskBottomSheet : HomeEffect()
    data class ShowDeleteConfirmationDialog(val taskItem: TaskItem) : HomeEffect()
}