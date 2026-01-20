package com.jackslan.taskmanager.data.local

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.Flow

class FakeDataStoreManager : DataStoreManager {

    private val _coordinatesFlow = MutableStateFlow("")
    private val _darkModeFlow = MutableStateFlow(false)

    override val coordinatesFlow: Flow<String> = _coordinatesFlow
    override val darkModeFlow: Flow<Boolean> = _darkModeFlow

    var storedCoordinates: String? = null
    var storedDarkMode: Boolean? = null

    override suspend fun storeDarkMode(isDarkMode: Boolean) {
        storedDarkMode = isDarkMode
        _darkModeFlow.value = isDarkMode
    }

    override suspend fun storeCoordinates(coordinates: String) {
        storedCoordinates = coordinates
        _coordinatesFlow.value = coordinates
    }
}
