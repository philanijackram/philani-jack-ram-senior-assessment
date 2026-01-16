package com.jackslan.taskmanager.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jackslan.taskmanager.domain.model.TodoItem
import com.jackslan.taskmanager.domain.model.dummyTodoList

@Composable
fun TaskListCard(
    title: String = "To Do",
    todoItems: List<TodoItem> = dummyTodoList
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = title,
                modifier = Modifier.padding(8.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            repeat(2) {
                TaskItemCard(
                    title = todoItems[it].title,
                    description = todoItems[it].description,
                    isCompleted = todoItems[it].isCompleted
                )
            }


        }
    }

}

@Preview(showBackground = true)
@Composable
fun TaskListCardPreview() {
    TaskListCard()
}