package com.jackslan.taskmanager.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jackslan.taskmanager.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun CreateNewTaskBottomSheet(
    title: String = "Title",
    description: String = "Description",
    onTitleChange: (String) -> Unit = {},
    onDescriptionChange: (String) -> Unit = {},
    onConfirm: () -> Unit = {},
    onDismiss: () -> Unit = {},
) {
    val sheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        modifier = Modifier.fillMaxWidth(),
        onDismissRequest = {
            onDismiss()
        },
        sheetState = sheetState
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.create_new_task),
                style = typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)
            )

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                value = title,
                onValueChange = onTitleChange,
                label = { Text(stringResource(R.string.title)) }
            )

            TextField(
                value = description,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                onValueChange = onDescriptionChange,
                label = { Text(stringResource(R.string.description)) }
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Green,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp),
                    onClick = {
                        onConfirm()
                    }) {
                    Text(stringResource(R.string.create))
                }


                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ),
                    modifier = Modifier.weight(1f),
                    onClick = {
                        onDismiss()
                    }) {
                    Text(stringResource(R.string.cancel))
                }
            }
        }
    }
}