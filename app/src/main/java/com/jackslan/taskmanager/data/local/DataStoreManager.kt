package com.jackslan.taskmanager.data.local

import kotlinx.coroutines.flow.Flow

interface DataStoreManager {
    val locationFlow: Flow<String>
    val darkModeFlow: Flow<Boolean>

    suspend fun storeLocation(coordinates: String)
    suspend fun storeDarkMode(isDarkMode: Boolean)
}