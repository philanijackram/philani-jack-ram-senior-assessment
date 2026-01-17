package com.jackslan.taskmanager.presentation.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.jackslan.taskmanager.R
import com.jackslan.taskmanager.domain.model.TaskItem
import com.jackslan.taskmanager.domain.model.dummyTodoList

@Preview(showBackground = true)
@Composable
fun ViewEditTaskDialog(
    onDismissRequest: () -> Unit = {},
    taskItem: TaskItem = dummyTodoList[0],
    onEditClick: () -> Unit = {}
) {

    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .padding(vertical = 16.dp, horizontal = 8.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center

            ) {
//                Text(
//                    text = taskItem.title,
//                    textAlign = TextAlign.Center,
//                )

                OutlinedTextField(
                    value = taskItem.title,
                    onValueChange = {},
                    colors = TextFieldDefaults.colors(
                        disabledTextColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    )
                )

                OutlinedTextField(
                    maxLines = 4,
                    minLines = 4,
                    value = taskItem.description ?: "",
                    onValueChange = {},
                    modifier = Modifier.padding(vertical = 8.dp),
                    colors = TextFieldDefaults.colors(
                        disabledTextColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    )

                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(R.string.completed),
                        modifier = Modifier
                    )

                    IconButton(
                        modifier = Modifier.wrapContentSize(),
                        onClick = { }
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

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
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
                            onEditClick()
                            onDismissRequest()
                        }) {
                        Text(stringResource(R.string.update))
                    }

                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Red,
                            contentColor = Color.White
                        ),
                        modifier = Modifier.weight(1f),
                        onClick = {
                            onDismissRequest()
                        }) {
                        Text(text = stringResource(R.string.cancel))
                    }
                }

            }


        }
    }
}