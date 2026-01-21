package com.jackslan.taskmanager.presentation.features.home.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import com.jackslan.taskmanager.R
import com.jackslan.taskmanager.domain.model.TaskItem
import com.jackslan.taskmanager.domain.model.dummyTodoList
import com.jackslan.taskmanager.presentation.theme.Dimens
import com.jackslan.taskmanager.presentation.theme.Typography

@Preview(showBackground = true)
@Composable
fun ViewEditTaskDialog(
    taskItem: TaskItem = dummyTodoList[0],
    onDismissRequest: () -> Unit = {},
    onTaskChange: (TaskItem) -> Unit = {},
    onUpdateClick: () -> Unit = {}
) {

    Dialog(onDismissRequest = { }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimens.mediumDialogHeight)
                .padding(vertical = Dimens.largePadding, horizontal = Dimens.mediumPadding),
            shape = RoundedCornerShape(Dimens.largePadding),
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(Dimens.largePadding),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {

                item {
                    OutlinedTextField(
                        placeholder = {
                            Text(
                                text = stringResource(R.string.title_placeholder),
                                style = Typography.bodyMedium
                            )
                        },
                        textStyle = Typography.titleMedium.copy(fontWeight = FontWeight.Normal),
                        value = taskItem.title,
                        onValueChange = {
                            onTaskChange(taskItem.copy(title = it))
                        }
                    )
                }

                item {
                    OutlinedTextField(
                        placeholder = {
                            Text(
                                text = stringResource(R.string.description_placeholder),
                                style = Typography.bodyMedium
                            )
                        },
                        textStyle = Typography.bodyMedium,
                        maxLines = 3,
                        minLines = 3,
                        value = taskItem.description ?: "",
                        onValueChange = {
                            onTaskChange(taskItem.copy(description = it))
                        },
                        modifier = Modifier.padding(vertical = Dimens.mediumPadding)
                    )
                }

                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            style = Typography.bodyMedium,
                            text = stringResource(R.string.completed),
                            modifier = Modifier
                        )

                        IconButton(
                            modifier = Modifier.wrapContentSize(),
                            onClick = {
                                onTaskChange(taskItem.copy(isCompleted = !taskItem.isCompleted))
                            }
                        ) {
                            Icon(
                                painter = painterResource(
                                    if (taskItem.isCompleted) {
                                        R.drawable.checked_icon
                                    } else {
                                        R.drawable.unchecked_icon
                                    }
                                ),
                                contentDescription = stringResource(R.string.check_indicator),
                                )
                        }
                    }
                }

                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = Dimens.mediumPadding),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Button(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.secondary,
                                contentColor = MaterialTheme.colorScheme.onSecondary
                            ),
                            border = BorderStroke(
                                width = Dimens.borderSize,
                                color = MaterialTheme.colorScheme.primary
                            ),
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = Dimens.mediumPadding),
                            onClick = {
                                onUpdateClick()
                                onDismissRequest()
                            }) {
                            Text(
                                text = stringResource(R.string.update),
                                style = Typography.bodyMedium
                            )
                        }

                        Button(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.primary,
                                contentColor = MaterialTheme.colorScheme.onPrimary
                            ),
                            border = BorderStroke(
                                width = Dimens.borderSize,
                                color = MaterialTheme.colorScheme.secondary
                            ),
                            modifier = Modifier.weight(1f),
                            onClick = {
                                onDismissRequest()
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
    }
}