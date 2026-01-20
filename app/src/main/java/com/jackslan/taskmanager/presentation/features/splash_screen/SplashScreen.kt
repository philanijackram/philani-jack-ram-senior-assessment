package com.jackslan.taskmanager.presentation.features.splash_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.jackslan.taskmanager.R

@Preview(showBackground = true)
@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    onNavigateToHome: () -> Unit = {}
) {

    LaunchedEffect(true) {
        Thread.sleep(3000)
        onNavigateToHome()
    }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.task_manager_logo),
            contentDescription = stringResource(R.string.task_manager_logo)
        )
    }
}