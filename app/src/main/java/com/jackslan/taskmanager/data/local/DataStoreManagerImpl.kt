package com.jackslan.taskmanager.data.local

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "app_prefs")

class DataStoreManagerImpl(
    private val context: Context
) : DataStoreManager {

    companion object {
        val COORDINATES = stringPreferencesKey("COORDINATES")
        val DARK_MODE = booleanPreferencesKey("DARK_MODE")
    }

    override suspend fun storeDarkMode(isDarkMode: Boolean) {
        context.dataStore.edit {
            it[DARK_MODE] = isDarkMode
        }
    }

    override suspend fun storeCoordinates(coordinates: String) {
        context.dataStore.edit {
            it[COORDINATES] = coordinates
        }
    }

    override val coordinatesFlow: Flow<String> = context.dataStore.data.map {
        it[COORDINATES] ?: ""
    }

    override val darkModeFlow: Flow<Boolean> = context.dataStore.data.map {
        it[DARK_MODE] ?: false
    }

}