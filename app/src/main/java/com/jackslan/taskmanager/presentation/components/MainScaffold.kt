package com.jackslan.taskmanager.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun MainScaffold(
    content: @Composable (modifier: Modifier) -> Unit = {}
) {
    Scaffold(
        floatingActionButton = {},
        floatingActionButtonPosition = FabPosition.End,

    ) {
        content(Modifier.padding(it))
    }
}

@Preview(showBackground = true)
@Composable
fun MainScaffoldPreview() {
    MainScaffold()
}