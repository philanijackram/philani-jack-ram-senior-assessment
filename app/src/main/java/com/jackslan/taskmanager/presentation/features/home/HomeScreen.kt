package com.jackslan.taskmanager.presentation.features.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jackslan.taskmanager.domain.model.TodoItem
import com.jackslan.taskmanager.domain.model.dummyTodoList
import com.jackslan.taskmanager.presentation.components.FilterPills
import com.jackslan.taskmanager.presentation.components.TaskItemCard
import com.jackslan.taskmanager.presentation.components.WeatherSectionCard

@Composable
fun HomeScreen(
    modifier: Modifier,
    onToDoClick: () -> Unit = {},
    onCompletedClick: () -> Unit = {},
    todoList: List<TodoItem> = dummyTodoList
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        WeatherSectionCard()

        FilterPills()

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

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(modifier = Modifier)
}

