package com.jackslan.taskmanager.presentation.features.home.state

import com.jackslan.taskmanager.domain.model.WeatherItem

data class WeatherUiState(
    val isLoading: Boolean = false,
    val weatherData: WeatherItem? = null,
    val error: String? = null
)