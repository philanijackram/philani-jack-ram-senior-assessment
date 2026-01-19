package com.jackslan.taskmanager.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jackslan.taskmanager.R
import com.jackslan.taskmanager.domain.model.TaskItem
import com.jackslan.taskmanager.domain.model.dummyTodoList
import com.jackslan.taskmanager.presentation.theme.Typography

@Composable
fun TaskItemCard(
    taskItem: TaskItem = dummyTodoList[0],
    onCheckedChange: (Int) -> Unit = {},
    onItemClick: (TaskItem) -> Unit = {},
    onDeleteClick: (TaskItem) -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onItemClick(taskItem) },
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
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
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .clickable {
                            onCheckedChange(taskItem.id)
                        }
                )

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        style = Typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        text = taskItem.title
                    )

                    if (!taskItem.description.isNullOrEmpty()) {
                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            style = Typography.bodyMedium,
                            fontWeight = FontWeight.Light,
                            text = taskItem.description,
                        )
                    }
                }
            }

            IconButton(
                modifier = Modifier
                    .weight(0.2f),
                onClick = { onDeleteClick(taskItem) }
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = stringResource(R.string.delete_icon)
                )
            }
        }

    }
}

@Preview(showBackground = true,)
@Composable
fun TaskItemCardPreview() {
    TaskItemCard()
}


