package com.jackslan.taskmanager.domain.repository

import com.jackslan.taskmanager.domain.model.TaskItem
import kotlinx.coroutines.flow.Flow

interface ToDoRepository {
    suspend fun createTaskItem(taskItem: TaskItem)
    suspend fun getTaskById(id: Int): TaskItem?
    suspend fun getAllTasks(): Flow<List<TaskItem>>
    suspend fun getIncompleteTaskList(): Flow<List<TaskItem>>
    suspend fun getCompletedTaskList(): Flow<List<TaskItem>>
    suspend fun updateTaskItem(taskItem: TaskItem)
    suspend fun updateTaskStatus(taskId: Int)
    suspend fun deleteTaskItem(taskId: Int)
}