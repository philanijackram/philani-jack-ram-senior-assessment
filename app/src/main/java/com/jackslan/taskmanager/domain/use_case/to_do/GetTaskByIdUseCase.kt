package com.jackslan.taskmanager.domain.use_case.to_do

import com.jackslan.taskmanager.domain.model.TaskItem
import com.jackslan.taskmanager.domain.repository.ToDoRepository
import javax.inject.Inject

class GetTaskByIdUseCase @Inject constructor(
    private val toDoRepository: ToDoRepository
) {
    suspend operator fun invoke(taskId: Int): TaskItem? {
        return toDoRepository.getTaskById(taskId)
    }
}