package com.jackslan.taskmanager.presentation.features.settings

import com.jackslan.taskmanager.data.local.FakeDataStoreManager
import com.jackslan.taskmanager.presentation.features.settings.state.SettingsEvent
import com.jackslan.taskmanager.presentation.features.settings.ui.SettingsViewModel
import com.jackslan.taskmanager.utils.MainDispatcherRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class SettingsViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var fakeDataStoreManager: FakeDataStoreManager
    private lateinit var viewModel: SettingsViewModel

    @Before
    fun setup() {
        fakeDataStoreManager = FakeDataStoreManager()
        viewModel = SettingsViewModel(fakeDataStoreManager)
    }

    @Test
    fun init_collectsDarkModeFromDataStore() = runTest {
        fakeDataStoreManager.storeDarkMode(true)
        advanceUntilIdle()

        assertTrue(viewModel.uiState.darkMode)
    }

    @Test
    fun onDarkModeChange_updatesUiStateAndStoresValue() = runTest {
        viewModel.onEvent(SettingsEvent.OnDarkModeChange(true))
        advanceUntilIdle()

        assertEquals(true, fakeDataStoreManager.storedDarkMode)
        assertTrue(viewModel.uiState.darkMode)
    }

}