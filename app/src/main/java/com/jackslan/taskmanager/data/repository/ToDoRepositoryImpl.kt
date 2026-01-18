package com.jackslan.taskmanager.data.repository

import com.jackslan.taskmanager.data.local.ToDoDao
import com.jackslan.taskmanager.data.mappers.toDomain
import com.jackslan.taskmanager.data.mappers.toEntity
import com.jackslan.taskmanager.domain.model.TaskItem
import com.jackslan.taskmanager.domain.repository.ToDoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ToDoRepositoryImpl @Inject constructor(
    private val toDoDao: ToDoDao
) : ToDoRepository {

    override suspend fun getAllTasks(): Flow<List<TaskItem>> {
        return toDoDao.getAllTasks().map { taskList ->
            taskList.map { taskEntity -> taskEntity.toDomain() }
        }
    }

    override suspend fun getTaskById(id: Int): TaskItem? {
        return toDoDao.getTaskById(id)?.toDomain()
    }

    override suspend fun getIncompleteTaskList(): Flow<List<TaskItem>> {
        return toDoDao.getIncompleteTasks().map { taskList ->
            taskList.map { taskEntity -> taskEntity.toDomain() }
        }
    }

    override suspend fun getCompletedTaskList(): Flow<List<TaskItem>> {
        return toDoDao.getCompletedTasks().map { taskList ->
            taskList.map { taskEntity -> taskEntity.toDomain() }
        }
    }

    override suspend fun createTaskItem(taskItem: TaskItem) {
        toDoDao.insertTask(taskItem.toEntity())
    }

    override suspend fun updateTaskItem(taskItem: TaskItem) {
        toDoDao.updateTask(taskItem.toEntity())
    }

    override suspend fun updateTaskStatus(taskId: Int) {
        val task = toDoDao.getTaskById(taskId)
        if (task != null) {
            val updatedTask = task.copy(isCompleted = !task.isCompleted)
            toDoDao.updateTask(updatedTask)
        }
    }

    override suspend fun deleteTaskItem(taskId: Int) {
        toDoDao.deleteTask(taskId)
    }

}