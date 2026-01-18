package com.jackslan.taskmanager.presentation.features.home.state

import com.jackslan.taskmanager.domain.model.TaskItem

data class HomeUiState(
    val isLoading: Boolean = false,
    val selectedFilter: String = "ALL",
    val showFab: Boolean = true,
    val error: String? = null,
    val tasks: List<TaskItem> = emptyList(),
    val title: String = "",
    val description: String = ""
)