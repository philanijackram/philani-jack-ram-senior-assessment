package com.jackslan.taskmanager.domain.use_case.to_do

import com.jackslan.taskmanager.domain.repository.ToDoRepository
import javax.inject.Inject

class UpdateTaskStatusUseCase @Inject constructor(
    private val toDoRepository: ToDoRepository
) {
    suspend operator fun invoke(taskId: Int) {
        toDoRepository.updateTaskStatus(taskId)
    }
}