package com.jackslan.taskmanager.presentation.features.home.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jackslan.taskmanager.R
import com.jackslan.taskmanager.presentation.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun CreateNewTaskBottomSheet(
    title: String = stringResource(R.string.title_placeholder),
    description: String = stringResource(R.string.description_placeholder),
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
                style = Typography.titleLarge,
                modifier = Modifier.padding(8.dp)
            )

            OutlinedTextField(
                textStyle = Typography.bodyMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                value = title,
                onValueChange = onTitleChange,
                placeholder = {
                    Text(
                        text = stringResource(R.string.title_placeholder),
                        style = Typography.bodyMedium
                    )
                },
            )

            OutlinedTextField(
                placeholder = {
                    Text(
                        text = stringResource(R.string.description_placeholder),
                        style = Typography.bodyMedium
                    )
                },
                maxLines = 3,
                textStyle = Typography.bodyMedium,
                value = description,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                onValueChange = onDescriptionChange,
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
                        onConfirm()
                    }) {
                    Text(
                        text = stringResource(R.string.create),
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
                        onDismiss()
                    }) {
                    Text(
                        text = stringResource(R.string.cancel),
                        style = Typography.bodyMedium
                    )
                }
            }
        }
    }
}