package com.jackslan.taskmanager.presentation.features.home.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jackslan.taskmanager.domain.model.TaskItem
import com.jackslan.taskmanager.domain.use_case.CreateNewTaskUseCase
import com.jackslan.taskmanager.domain.use_case.DeleteTaskUseCase
import com.jackslan.taskmanager.domain.use_case.GetAllTasksUseCase
import com.jackslan.taskmanager.domain.use_case.GetCompletedTasksUseCase
import com.jackslan.taskmanager.domain.use_case.GetIncompleteTasksUsesCase
import com.jackslan.taskmanager.domain.use_case.UpdateTaskStatusUseCase
import com.jackslan.taskmanager.domain.use_case.UpdateTaskUseCase
import com.jackslan.taskmanager.presentation.features.home.state.HomeEffect
import com.jackslan.taskmanager.presentation.features.home.state.HomeEvent
import com.jackslan.taskmanager.presentation.features.home.state.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val createNewTaskUseCase: CreateNewTaskUseCase,
    private val getAllTasksUseCase: GetAllTasksUseCase,
    private val getCompletedTasksUseCase: GetCompletedTasksUseCase,
    private val getIncompleteTasksUseCase: GetIncompleteTasksUsesCase,
    private val updateTaskUseCase: UpdateTaskUseCase,
    private val updateTaskStatusUseCase: UpdateTaskStatusUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
) : ViewModel() {

    var uiState by mutableStateOf(HomeUiState())
        private set

    private val _effect = MutableSharedFlow<HomeEffect>()
    val effect: MutableSharedFlow<HomeEffect> = _effect

    init {
        onEvent(HomeEvent.LoadTasks)
    }

    private fun createNewTask(title: String, description: String?) {
        viewModelScope.launch {

            uiState = uiState.copy(isLoading = true)
            createNewTaskUseCase(
                TaskItem(
                    title = title,
                    description = description,
                    isCompleted = false
                )
            )
            getAllTasks()

            uiState = uiState.copy(isLoading = false)
        }
    }

    fun getAllTasks() {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true)
            getAllTasksUseCase().collect { tasks ->
                uiState = uiState.copy(tasks = tasks, isLoading = false)
            }
        }
    }

    fun fetchTasks() {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true)
            when (uiState.selectedFilter) {
                "ALL" -> getAllTasksUseCase().collect { tasks ->
                    uiState = uiState.copy(tasks = tasks)
                }

                "TO DO" -> getIncompleteTasksUseCase().collect { tasks ->
                    uiState = uiState.copy(tasks = tasks)
                }

                "COMPLETED" -> getCompletedTasksUseCase().collect { tasks ->
                    uiState = uiState.copy(tasks = tasks)
                }

            }
            uiState = uiState.copy(isLoading = false)
        }
    }

    private fun deleteTask(taskId: Int) {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true)
            deleteTaskUseCase(taskId)
            getAllTasks()
            uiState = uiState.copy(isLoading = false)
        }
    }

    private fun updateTaskStatus(taskId: Int) {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true)
            updateTaskStatusUseCase(taskId)
            fetchTasks()
            uiState = uiState.copy(isLoading = false)
        }
    }

    private fun updateTask(taskItem: TaskItem) {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true)
            updateTaskUseCase(taskItem)
            uiState = uiState.copy(isLoading = false)
        }
    }

    private fun onFilterChange(filter: String) {
        uiState = uiState.copy(selectedFilter = filter, showFab = filter != "COMPLETED")

        fetchTasks()
    }

    private fun emitEffect(effect: HomeEffect) {
        viewModelScope.launch {
            _effect.emit(effect)
        }
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.LoadTasks -> getAllTasks()
            is HomeEvent.OnDeleteClick -> deleteTask(taskId = event.taskId)
            is HomeEvent.OnCheckChanged -> updateTaskStatus(taskId = event.taskId)
            is HomeEvent.OnTaskClick -> updateTask(event.taskItem)
            is HomeEvent.OnFabClick -> {

            }
            is HomeEvent.OnFilterChange -> onFilterChange(event.filter)
            is HomeEvent.OnCreateTaskClick -> createNewTask(event.title, event.description)
            is HomeEvent.OnTitleChange -> uiState = uiState.copy(title = event.title)
            is HomeEvent.OnDescriptionChange -> uiState =
                uiState.copy(description = event.description)
        }

    }

}
