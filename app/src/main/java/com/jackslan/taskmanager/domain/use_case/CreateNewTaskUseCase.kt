package com.jackslan.taskmanager.domain.use_case

import com.jackslan.taskmanager.domain.model.TaskItem
import com.jackslan.taskmanager.domain.repository.ToDoRepository
import javax.inject.Inject

class CreateNewTaskUseCase @Inject constructor(
    private val toDoRepository: ToDoRepository
) {
    suspend operator fun invoke(taskItem: TaskItem) {
        return toDoRepository.createTaskItem(taskItem)
    }
}