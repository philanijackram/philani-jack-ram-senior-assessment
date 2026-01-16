package com.jackslan.taskmanager.presentation.features.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jackslan.taskmanager.R
import com.jackslan.taskmanager.presentation.components.HomeItemCard
import com.jackslan.taskmanager.presentation.components.WeatherSectionCard

@Composable
fun HomeScreen(
    modifier: Modifier,
    onToDoClick: () -> Unit = {},
    onCompletedClick: () -> Unit = {}
) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        item {
            WeatherSectionCard()
        }

        item {
            HomeItemCard(
                title = "To Do",
                icon = R.drawable.unchecked_icon,
                onClick = onToDoClick
            )
        }

        item {
            HomeItemCard(
                title = "Completed",
                icon = R.drawable.checked_icon,
                onClick = onCompletedClick
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(modifier = Modifier)
}

