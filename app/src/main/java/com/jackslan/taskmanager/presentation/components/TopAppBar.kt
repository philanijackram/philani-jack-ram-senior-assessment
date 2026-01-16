package com.jackslan.taskmanager.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jackslan.taskmanager.R

@Composable
fun TopAppBar(
    title: String = "Task Manager",
    onNavigationIconClick: () -> Unit = {},
    onDarkModeIconClick: () -> Unit = {},
    ) {

    Row(
        modifier = Modifier.fillMaxWidth().height(56.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Icon(
            modifier = Modifier.height(24.dp),
            painter = painterResource(id = R.drawable.back_icon),
            contentDescription = ""
        )

        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge
        )

        Icon(
            painter = painterResource(R.drawable.dark_light_mode_icon),
            contentDescription = "dark light mode toggle"
        )

    }
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
    TopAppBar()
}