package com.jackslan.taskmanager.presentation.features.settings

sealed class SettingsEvent {
    data class OnDarkModeChange(val darkMode: Boolean) : SettingsEvent()
}
