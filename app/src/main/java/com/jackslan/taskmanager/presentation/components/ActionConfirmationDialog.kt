package com.jackslan.taskmanager.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.jackslan.taskmanager.presentation.theme.Typography

@Preview(showBackground = true)
@Composable
fun ActionConfirmationDialog(
    title: String = "Title",
    message: String = "Message",
    onPositiveClick: () -> Unit = {},
    onNegativeClick: () -> Unit = {},
    positiveButtonText: String = "Yes",
    negativeButtonText: String = "No",
    onDismissRequest: () -> Unit = {}
) {

    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(vertical = 16.dp, horizontal = 8.dp),
            shape = RoundedCornerShape(16.dp),
        ) {

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    style = Typography.titleMedium,
                    text = title,
                    textAlign = TextAlign.Center,
                )

                Text(
                    style = Typography.bodyMedium,
                    modifier = Modifier
                        .padding(8.dp),
                    text = message,
                    textAlign = TextAlign.Center,
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.secondary,
                            contentColor = MaterialTheme.colorScheme.onSecondary
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp),
                        border = BorderStroke(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.primary
                        ),
                        onClick = {
                            onPositiveClick()
                            onDismissRequest()
                        }) {
                        Text(
                            text = positiveButtonText,
                            style = Typography.bodyMedium
                        )
                    }

                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = MaterialTheme.colorScheme.onPrimary
                        ),
                        modifier = Modifier
                            .weight(1f),
                        border = BorderStroke(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.secondary
                        ),
                        onClick = {
                            onNegativeClick()
                            onDismissRequest()
                        }) {
                        Text(
                            text = negativeButtonText,
                            style = Typography.bodyMedium
                        )
                    }

                }

            }
        }
    }
}