package com.jackslan.taskmanager.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jackslan.taskmanager.R


@Composable
fun MainScaffold(
    modifier: Modifier = Modifier,
    title: String = stringResource(R.string.task_manager),
    onSettingsClick: () -> Unit = {},
    onBackClick: () -> Unit = {},
    onFabClick: () -> Unit = {},
    showFab: Boolean = true,
    fabPosition: FabPosition = FabPosition.End,
    fabIcon: Int = R.drawable.add_icon,
    showSettings: Boolean = true,
    content: @Composable (modifier: Modifier) -> Unit = {},

    ) {

    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .safeDrawingPadding()
                    .height(56.dp)
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (!showSettings) {
                    IconButton(
                        modifier = Modifier.size(24.dp),
                        onClick = onBackClick
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.navigation_icon)
                        )
                    }
                } else {
                    Spacer(modifier = Modifier.size(24.dp))
                }

                Text(
                    text = title,
                    style = typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                if (showSettings) {
                    IconButton(
                        modifier = Modifier.size(24.dp),
                        onClick = onSettingsClick
                    ) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            stringResource(R.string.settings_icon)
                        )
                    }
                } else {
                    Spacer(modifier = Modifier.size(24.dp))
                }

            }
        },
        floatingActionButton = {
            if (showFab) {
                FloatingActionButton(onClick = onFabClick) {
                    Icon(
                        painter = painterResource(fabIcon),
                        contentDescription = stringResource(R.string.fab_icon)
                    )
                }
            }
        },
        floatingActionButtonPosition = fabPosition,

        ) { paddingValues ->
        content(modifier.padding(paddingValues = paddingValues))

    }
}

@Preview(showBackground = true)
@Composable
fun MainScaffoldPreview() {
    MainScaffold()
}