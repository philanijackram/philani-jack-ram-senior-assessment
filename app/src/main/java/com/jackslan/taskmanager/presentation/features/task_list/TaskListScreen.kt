package com.jackslan.taskmanager.presentation.features.task_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun TaskListScreen(
    onCreateClick: () -> Unit = {},
    onItemClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Task List Screen")

        Button(
            onClick = { onCreateClick() }
        ) {
            Text(text = "Create Task")
        }

        Button(
            onClick = { onItemClick() }
        ) {
            Text(text = "Item 1")

        }
    }
}