package com.jackslan.taskmanager.presentation.features.settings

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jackslan.taskmanager.R
import com.jackslan.taskmanager.presentation.components.MainScaffold
import com.jackslan.taskmanager.presentation.components.SettingsItemCard

@Preview(showBackground = true)
@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel = hiltViewModel(),
    onBackClick: () -> Unit = {}
) {

    val uiState = viewModel.uiState

    MainScaffold(
        title = "Settings",
        showFab = false,
        showSettings = false,
        onBackClick = onBackClick
    ) {

        LazyColumn(
            modifier = Modifier
                .padding(top = 70.dp)
                .fillMaxSize()
        ) {

            item {
                SettingsItemCard(
                    icon = R.drawable.dark_light_mode_icon,
                    checked = uiState.darkMode,
                    onCheckedChange = {
                        viewModel.onEvent(SettingsEvent.OnDarkModeChange(it))
                    },
                    title = stringResource(R.string.dark_mode)
                )
            }

        }
    }
}