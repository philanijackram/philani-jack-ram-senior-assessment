package com.jackslan.taskmanager.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jackslan.taskmanager.domain.model.TaskItem
import com.jackslan.taskmanager.domain.model.dummyTodoList
import com.jackslan.taskmanager.presentation.components.TaskItemCard

@Composable
fun TaskListSection(
    modifier: Modifier = Modifier,
    todoList: List<TaskItem> = dummyTodoList,
    onItemClick: (TaskItem) -> Unit = {},
    onCheckedChange: (Int) -> Unit = {}
) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        items(todoList.size) {
            TaskItemCard(
                taskItem = todoList[it],
                onCheckedChange = onCheckedChange,
                onItemClick = onItemClick
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun TaskListSectionPreview() {
    TaskListSection()
}