package com.jackslan.taskmanager.presentation.features.weather

import com.jackslan.taskmanager.domain.model.WeatherItem

data class WeatherUiState(
    val isLoading: Boolean = false,
    val weatherData: WeatherItem? = null,
    val error: String? = null
)