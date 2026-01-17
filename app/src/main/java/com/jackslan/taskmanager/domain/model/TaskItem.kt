package com.jackslan.taskmanager.domain.model

data class TaskItem(
    val id: Int,
    val title: String,
    val description: String?,
    val isCompleted: Boolean = false
)

val dummyTodoList = listOf(
    TaskItem(1, "Task 1", "Description of Task 1"),
    TaskItem(2, "Task 2", "Description of Task 2"),
    TaskItem(3, "Task 3", null),
    TaskItem(4, "Task 4", "Description of Task 1"),

    )