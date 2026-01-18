package com.jackslan.taskmanager.domain.repository

import com.jackslan.taskmanager.data.remote.model.WeatherResponse

interface WeatherRepository {

    suspend fun getWeatherData(
        coordinates: String,
        days: Int,
    ): WeatherResponse

}