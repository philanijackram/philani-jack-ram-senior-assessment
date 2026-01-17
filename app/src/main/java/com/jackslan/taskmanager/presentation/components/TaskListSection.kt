package com.jackslan.taskmanager.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jackslan.taskmanager.domain.model.TaskItem
import com.jackslan.taskmanager.domain.model.dummyTodoList

@Composable
fun TaskListSection(
    modifier: Modifier = Modifier,
    todoList: List<TaskItem> = dummyTodoList
) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        items(todoList.size) {
            TaskItemCard(
                title = todoList[it].title,
                description = todoList[it].description,
                isCompleted = todoList[it].isCompleted
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun TaskListSectionPreview() {
    TaskListSection()
}