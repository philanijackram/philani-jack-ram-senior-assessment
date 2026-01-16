package com.jackslan.taskmanager.presentation.features.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.jackslan.taskmanager.R
import com.jackslan.taskmanager.domain.model.TodoItem
import com.jackslan.taskmanager.domain.model.dummyTodoList
import com.jackslan.taskmanager.presentation.components.FilterPills
import com.jackslan.taskmanager.presentation.components.TaskItemCard
import com.jackslan.taskmanager.presentation.components.WeatherSectionCard
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    todoList: List<TodoItem> = dummyTodoList
) {

    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { showBottomSheet = true }) {
                Icon(
                    painter = painterResource(R.drawable.add_icon),
                    contentDescription = "FAB"
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End,

        ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            WeatherSectionCard()

            FilterPills()

            LazyColumn(
                modifier = modifier.fillMaxSize()
            ) {
                items(todoList.size) {
                    TaskItemCard(
                        title = todoList[it].title,
                        description = todoList[it].description,
                        isCompleted = todoList[it].isCompleted
                    )
                }
            }
            if (showBottomSheet) {
                ModalBottomSheet(
                    modifier = Modifier.fillMaxWidth(),
                    onDismissRequest = {
                        showBottomSheet = false
                    },
                    sheetState = sheetState
                ) {
                    TextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("Title") }
                    )

                    TextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("Description") }
                    )

                    Row(){
                        // Sheet content
                        Button(
                            modifier = Modifier.weight(1f),
                            onClick = {
                            scope.launch { sheetState.hide() }.invokeOnCompletion {
                                if (!sheetState.isVisible) {
                                    showBottomSheet = false
                                }
                            }
                        }) {
                            Text("Hide bottom sheet")
                        }

                        // Sheet content
                        Button(
                            modifier = Modifier.weight(1f),
                            onClick = {
                            scope.launch { sheetState.hide() }.invokeOnCompletion {
                                if (!sheetState.isVisible) {
                                    showBottomSheet = false
                                }
                            }
                        }) {
                            Text("Hide bottom sheet")
                        }
                    }


                }
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(modifier = Modifier)
}

