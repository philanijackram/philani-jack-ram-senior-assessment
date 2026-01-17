package com.jackslan.taskmanager.presentation.features.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jackslan.taskmanager.R
import com.jackslan.taskmanager.domain.model.TaskItem
import com.jackslan.taskmanager.domain.model.dummyTodoList
import com.jackslan.taskmanager.presentation.components.ActionConfirmationDialog
import com.jackslan.taskmanager.presentation.components.CreateNewTaskBottomSheet
import com.jackslan.taskmanager.presentation.components.FilterPills
import com.jackslan.taskmanager.presentation.components.MainScaffold
import com.jackslan.taskmanager.presentation.components.TaskListSection
import com.jackslan.taskmanager.presentation.components.ViewEditTaskDialog
import com.jackslan.taskmanager.presentation.components.WeatherSection
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onSettingsClick: () -> Unit = {},
    todoList: List<TaskItem> = dummyTodoList
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    var showCreateTaskBottomSheet by remember { mutableStateOf(false) }
    var showTaskDetailsDialog by remember { mutableStateOf(false) }
    var showDeleteConfirmationDialog by remember { mutableStateOf(false) }

    var currentItem by remember { mutableStateOf<TaskItem?>(null) }


    MainScaffold(
        title = "Task Manager",
        onSettingsClick = onSettingsClick,
        showFab = true,
        fabIcon = R.drawable.add_icon,
        showSettings = true,
        onFabClick = {
            showCreateTaskBottomSheet = true
        }
    ) {
        Column(
            modifier = Modifier.padding(top = 60.dp)
        ) {

            WeatherSection()

            FilterPills()

            TaskListSection(
                todoList = todoList,
                onItemClick = {
                    showTaskDetailsDialog = true
                    currentItem = it
                },
                onCheckedChange = {

                },
                onDeleteClick = {
                    showDeleteConfirmationDialog = true
                }
            )

            if (showCreateTaskBottomSheet) {
                CreateNewTaskBottomSheet(
                    title = title,
                    description = description,
                    onTitleChange = { title = it },
                    onDescriptionChange = { description = it },
                    onDismiss = {

                        scope.launch { sheetState.hide() }.invokeOnCompletion {
                            if (!sheetState.isVisible) {
                                showCreateTaskBottomSheet = false
                            }
                        }

                        title = ""
                        description = ""
                    },
                    onConfirm = {
                        scope.launch { sheetState.hide() }.invokeOnCompletion {
                            if (!sheetState.isVisible) {
                                showCreateTaskBottomSheet = false
                            }
                        }
                        title = ""
                        description = ""
                    },
                )
            }

            if (showTaskDetailsDialog) {
                currentItem?.let { item ->
                    ViewEditTaskDialog(
                        onDismissRequest = { showTaskDetailsDialog = false },
                        taskItem = item
                    )
                }

            }

            if (showDeleteConfirmationDialog) {
                ActionConfirmationDialog(
                    title = stringResource(R.string.delete_task),
                    message = stringResource(R.string.are_you_sure_you_want_to_delete_this_task),
                    onPositiveClick = {
                        showDeleteConfirmationDialog = false
                    },
                    onNegativeClick = {
                        showDeleteConfirmationDialog = false
                    },
                    onDismissRequest = {
                        showDeleteConfirmationDialog = false
                    }

                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(modifier = Modifier)
}

