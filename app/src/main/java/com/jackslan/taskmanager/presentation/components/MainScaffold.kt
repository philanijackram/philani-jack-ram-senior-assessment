package com.jackslan.taskmanager.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.jackslan.taskmanager.R


@Composable
fun MainScaffold(
    content: @Composable (modifier: Modifier) -> Unit = {}
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(R.drawable.add_icon),
                    contentDescription = "FAB"
                )
            }
        },
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