package com.jackslan.taskmanager.presentation.features.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jackslan.taskmanager.R
import com.jackslan.taskmanager.domain.model.TaskItem
import com.jackslan.taskmanager.presentation.components.ActionConfirmationDialog
import com.jackslan.taskmanager.presentation.components.CreateNewTaskBottomSheet
import com.jackslan.taskmanager.presentation.components.FilterPills
import com.jackslan.taskmanager.presentation.components.MainScaffold
import com.jackslan.taskmanager.presentation.components.TaskListSection
import com.jackslan.taskmanager.presentation.components.ViewEditTaskDialog
import com.jackslan.taskmanager.presentation.components.WeatherSection
import com.jackslan.taskmanager.presentation.features.home.state.HomeEffect
import com.jackslan.taskmanager.presentation.features.home.state.HomeEvent
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onSettingsClick: () -> Unit = {},
) {

    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    var showCreateTaskBottomSheet by remember { mutableStateOf(false) }
    var showTaskDetailsDialog by remember { mutableStateOf(false) }
    var showDeleteConfirmationDialog by remember { mutableStateOf(false) }

    var currentItem by remember { mutableStateOf<TaskItem?>(null) }

    val uiState = viewModel.uiState

    LaunchedEffect(key1 = true) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is HomeEffect.LoadTasks -> {
                    //viewModel.fetchTasks()
                    viewModel.getWeatherData()
                }

                is HomeEffect.ShowCreateTaskBottomSheet -> {
                    scope.launch { sheetState.show() }
                }

                is HomeEffect.ShowTaskDetailsDialog -> {
                    showTaskDetailsDialog = true
                    currentItem = effect.taskItem
                }

                is HomeEffect.ShowError -> {

                }

                is HomeEffect.ShowDeleteConfirmationDialog -> {
                    showDeleteConfirmationDialog = true
                    currentItem = effect.taskItem
                }

            }
        }
    }

    MainScaffold(
        title = stringResource(R.string.task_manager),
        onSettingsClick = onSettingsClick,
        showFab = uiState.showFab,
        fabIcon = R.drawable.add_icon,
        showSettings = true,
        onFabClick = {
            showCreateTaskBottomSheet = true
        }
    ) {
        Column(
            modifier = Modifier.padding(top = 60.dp)
        ) {

            WeatherSection(
                weatherItem = viewModel.weatherUiState.weatherData
            )

            FilterPills(
                selectedOption = uiState.selectedFilter,
                onFilterChange = {
                    viewModel.onEvent(HomeEvent.OnFilterChange(it))
                },
                filterOptions = listOf("ALL", "TO DO", "COMPLETED")
            )

            TaskListSection(
                todoList = uiState.tasks,
                onItemClick = {
                    showTaskDetailsDialog = true
                    currentItem = it
                },
                onCheckedChange = { taskId ->
                    viewModel.onEvent(HomeEvent.OnCheckChanged(taskId))
                },
                onDeleteClick = { taskItem ->
                    showDeleteConfirmationDialog = true
                    currentItem = taskItem
                }
            )

            if (showCreateTaskBottomSheet) {
                CreateNewTaskBottomSheet(
                    title = uiState.title,
                    description = uiState.description,
                    onTitleChange = {
                        viewModel.onEvent(HomeEvent.OnTitleChange(it))
                    },
                    onDescriptionChange = {
                        viewModel.onEvent(HomeEvent.OnDescriptionChange(it))
                    },
                    onDismiss = {
                        scope.launch { sheetState.hide() }.invokeOnCompletion {
                            if (!sheetState.isVisible) {
                                showCreateTaskBottomSheet = false
                            }
                        }
                        viewModel.onEvent(HomeEvent.OnTitleChange(""))
                        viewModel.onEvent(HomeEvent.OnDescriptionChange(""))
                    },
                    onConfirm = {
                        viewModel.onEvent(
                            HomeEvent.OnCreateTaskClick(
                                title = uiState.title,
                                description = uiState.description
                            )
                        )
                        scope.launch { sheetState.hide() }.invokeOnCompletion {
                            if (!sheetState.isVisible) {
                                showCreateTaskBottomSheet = false
                            }
                        }
                        viewModel.onEvent(HomeEvent.OnTitleChange(""))
                        viewModel.onEvent(HomeEvent.OnDescriptionChange(""))
                    },
                )
            }

            if (showTaskDetailsDialog) {
                currentItem?.let { item ->
                    ViewEditTaskDialog(
                        onDismissRequest = { showTaskDetailsDialog = false },
                        taskItem = item
                    )
                }

            }

            if (showDeleteConfirmationDialog) {
                ActionConfirmationDialog(
                    title = stringResource(R.string.delete_task),
                    message = stringResource(R.string.are_you_sure_you_want_to_delete_this_task),
                    onPositiveClick = {
                        viewModel.onEvent(HomeEvent.OnDeleteClick(currentItem?.id ?: -1))
                        showDeleteConfirmationDialog = false
                    },
                    onNegativeClick = {
                        showDeleteConfirmationDialog = false
                    },
                    onDismissRequest = {
                        showDeleteConfirmationDialog = false
                    }
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

