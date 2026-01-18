package com.jackslan.taskmanager.domain.repository

import com.jackslan.taskmanager.data.remote.model.WeatherResponse

interface WeatherRepository {

    suspend fun getWeatherData(
        latitude: Double,
        longitude: Double,
        days: Int,
    ): WeatherResponse

}