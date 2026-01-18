package com.jackslan.taskmanager.data.local

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.myDataStore by preferencesDataStore(name = "app_prefs")

class DataStoreManager(
    private val context: Context
) {

    companion object {
        val LOCATION = stringPreferencesKey("LOCATION")
    }

    suspend fun storeLocation(coordinates: String) {
        context.myDataStore.edit {
            it[LOCATION] = coordinates
        }
    }

    val locationFlow: Flow<String> = context.myDataStore.data.map {
        it[LOCATION] ?: ""
    }
}