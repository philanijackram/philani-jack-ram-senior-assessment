package com.jackslan.taskmanager.data.local

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.Flow

class FakeDataStoreManager : DataStoreManager {

    private val _locationFlow = MutableStateFlow("")
    private val _darkModeFlow = MutableStateFlow(false)

    override val locationFlow: Flow<String> = _locationFlow
    override val darkModeFlow: Flow<Boolean> = _darkModeFlow

    var storedLocation: String? = null
    var storedDarkMode: Boolean? = null

    override suspend fun storeDarkMode(isDarkMode: Boolean) {
        storedDarkMode = isDarkMode
        _darkModeFlow.value = isDarkMode
    }

    override suspend fun storeLocation(coordinates: String) {
        storedLocation = coordinates
        _locationFlow.value = coordinates
    }
}
