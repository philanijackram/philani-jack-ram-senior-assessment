package com.jackslan.taskmanager.presentation.features.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jackslan.taskmanager.R
import com.jackslan.taskmanager.domain.model.TaskItem
import com.jackslan.taskmanager.domain.model.dummyTodoList
import com.jackslan.taskmanager.presentation.components.CreateNewTaskBottomSheet
import com.jackslan.taskmanager.presentation.components.FilterPills
import com.jackslan.taskmanager.presentation.components.MainScaffold
import com.jackslan.taskmanager.presentation.components.TaskListSection
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
    var showBottomSheet by remember { mutableStateOf(false) }

    MainScaffold(
        title = "Task Manager",
        onSettingsClick = onSettingsClick,
        showFab = true,
        fabIcon = R.drawable.add_icon,
        showSettings = true,
        onFabClick = {
            showBottomSheet = true
        }
    ) {
        Column(
            modifier = Modifier.padding(top = 60.dp)
        ) {

            WeatherSection()

            FilterPills()

            TaskListSection(

                todoList = todoList
            )

            if (showBottomSheet) {
                CreateNewTaskBottomSheet(
                    title = title,
                    description = description,
                    onTitleChange = { title = it },
                    onDescriptionChange = { description = it },
                    onDismiss = {

                        scope.launch { sheetState.hide() }.invokeOnCompletion {
                            if (!sheetState.isVisible) {
                                showBottomSheet = false
                            }
                        }

                        title = ""
                        description = ""
                    },
                    onConfirm = {
                        scope.launch { sheetState.hide() }.invokeOnCompletion {
                            if (!sheetState.isVisible) {
                                showBottomSheet = false
                            }
                        }
                        title = ""
                        description = ""
                    },
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

