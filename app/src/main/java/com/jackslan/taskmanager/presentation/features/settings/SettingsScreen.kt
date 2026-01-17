package com.jackslan.taskmanager.presentation.features.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jackslan.taskmanager.presentation.components.MainScaffold

@Preview(showBackground = true)
@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {}
) {

    MainScaffold(
        title = "Settings",
        showFab = false,
        showSettings = false,
        onBackClick = onBackClick
    ) {

        Box(
            modifier = Modifier
                .padding(top = 60.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Settings screen")
        }
    }
}