package com.jackslan.taskmanager.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jackslan.taskmanager.R
import com.jackslan.taskmanager.presentation.theme.Typography

@Composable
fun TopAppBar(
    title: String = "Task Manager",
    onNavigationIconClick: () -> Unit = {},
    onDarkModeIconClick: () -> Unit = {},
    ) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Icon(
            modifier = Modifier.height(24.dp),
            painter = painterResource(id = R.drawable.back_icon),
            contentDescription = stringResource(R.string.back_icon)
        )

        Text(
            text = title,
            style = Typography.titleLarge
        )

        Icon(
            painter = painterResource(R.drawable.dark_light_mode_icon),
            contentDescription = stringResource(R.string.dark_light_mode_toggle)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
    TopAppBar()
}