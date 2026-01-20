package com.jackslan.taskmanager.presentation.features.settings.state

sealed class SettingsEvent {
    data class OnDarkModeChange(val darkMode: Boolean) : SettingsEvent()
}
