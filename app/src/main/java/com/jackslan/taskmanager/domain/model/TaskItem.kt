package com.jackslan.taskmanager.domain.model

data class TaskItem(
    val id: Int = 0,
    val title: String,
    val description: String?,
    val isCompleted: Boolean = false
)

val dummyTodoList = listOf(
    TaskItem(
        1, "Task 1", ""
    ),
    TaskItem(2, "Task 2", "Description of Task 2"),
    TaskItem(3, "Task 3", null, isCompleted = true),
    TaskItem(4, "Task 4", "Description of Task 4"),
    TaskItem(5, "Task 5", "Description of Task 5", isCompleted = true),
    TaskItem(6, "Task 6", "Description of Task 6"),
    TaskItem(7, "Task 7", null, isCompleted = true),
    TaskItem(8, "Task 8", null, isCompleted = true),
    TaskItem(9, "Task 9", "Description of Task 9"),

    )