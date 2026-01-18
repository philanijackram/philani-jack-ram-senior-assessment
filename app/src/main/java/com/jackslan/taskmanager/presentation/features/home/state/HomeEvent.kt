package com.jackslan.taskmanager.presentation.features.home.state

import com.jackslan.taskmanager.domain.model.TaskItem

sealed class HomeEvent {
    object LoadTasks : HomeEvent()
    data class OnTaskClick(val taskItem: TaskItem) : HomeEvent()
    data class OnCreateTaskClick(val title: String, val description: String?) : HomeEvent()
    data class OnCheckChanged(val taskId: Int) : HomeEvent()
    data class OnDeleteClick(val taskId: Int) : HomeEvent()
    object OnFabClick : HomeEvent()
    data class OnFilterChange(val filter: String) : HomeEvent()
    data class OnTitleChange(val title: String) : HomeEvent()
    data class OnDescriptionChange(val description: String) : HomeEvent()
}
