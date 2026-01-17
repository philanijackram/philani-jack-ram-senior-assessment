package com.jackslan.taskmanager.domain.use_case

import com.jackslan.taskmanager.domain.repository.ToDoRepository
import javax.inject.Inject

class DeleteTaskUseCase @Inject constructor(
    private val toDoRepository: ToDoRepository
) {
    suspend operator fun invoke(taskId: Int) {
        return toDoRepository.deleteTaskItem(taskId)
    }
}