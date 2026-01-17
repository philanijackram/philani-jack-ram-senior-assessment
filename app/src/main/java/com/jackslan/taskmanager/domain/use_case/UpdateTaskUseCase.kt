package com.jackslan.taskmanager.domain.use_case

import com.jackslan.taskmanager.domain.model.TaskItem
import com.jackslan.taskmanager.domain.repository.ToDoRepository
import javax.inject.Inject

class UpdateTaskUseCase @Inject constructor(
    private val toDoRepository: ToDoRepository
) {
    suspend operator fun invoke(taskItem: TaskItem) {
        toDoRepository.updateTaskItem(taskItem)
    }
}