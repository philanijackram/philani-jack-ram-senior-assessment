package com.jackslan.taskmanager.data.local

import kotlinx.coroutines.flow.Flow

interface DataStoreManager {
    val coordinatesFlow: Flow<String>
    val darkModeFlow: Flow<Boolean>

    suspend fun storeCoordinates(coordinates: String)
    suspend fun storeDarkMode(isDarkMode: Boolean)
}