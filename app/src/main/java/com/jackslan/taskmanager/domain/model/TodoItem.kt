package com.jackslan.taskmanager.domain.model

data class TodoItem(
    val id: Int,
    val title: String,
    val description: String?,
    val isCompleted: Boolean = false
)

val dummyTodoList = listOf(
    TodoItem(1, "Task 1", "Description of Task 1"),
    TodoItem(2, "Task 2", "Description of Task 2"),
    TodoItem(3, "Task 3", null),
    TodoItem(4, "Task 4", "Description of Task 1"),

    )