package com.jackslan.taskmanager.domain.use_case

import com.jackslan.taskmanager.domain.model.TaskItem
import com.jackslan.taskmanager.domain.repository.ToDoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCompletedTasksUseCase @Inject constructor(
    private val toDoRepository: ToDoRepository
) {
    suspend operator fun invoke(): Flow<List<TaskItem>> {
        return toDoRepository.getCompletedTaskList()
    }
}