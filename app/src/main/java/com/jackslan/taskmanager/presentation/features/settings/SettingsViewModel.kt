package com.jackslan.taskmanager.presentation.features.settings

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jackslan.taskmanager.data.local.DataStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val dataStoreManager: DataStoreManager
) : ViewModel() {

    var uiState by mutableStateOf(SettingsUiState())
        private set

    init {
        viewModelScope.launch {
            dataStoreManager.darkModeFlow.collect { darkMode ->
                uiState = uiState.copy(darkMode = darkMode)
            }
        }
    }

    fun onEvent(event: SettingsEvent) {
        when (event) {
            is SettingsEvent.OnDarkModeChange -> {
                viewModelScope.launch {
                    dataStoreManager.storeDarkMode(event.darkMode)
                }
            }
        }
    }

}