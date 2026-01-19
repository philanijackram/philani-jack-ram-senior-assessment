package com.jackslan.taskmanager.data.repository

import android.util.Log
import com.jackslan.taskmanager.data.remote.api.ApiService
import com.jackslan.taskmanager.data.remote.model.WeatherResponse
import com.jackslan.taskmanager.domain.repository.WeatherRepository
import com.jackslan.taskmanager.utils.ImportantStrings
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : WeatherRepository {
    override suspend fun getWeatherData(
        coordinates: String,
        days: Int,
    ): WeatherResponse? {
        val response = apiService.getWeatherData(
            coordinates,
            days,
            ImportantStrings.WEATHER_API_KEY
        )
        if (response.isSuccessful) {
            Log.d("WeatherRepository", "Weather data fetched successfully ${response.body()}")
            return response.body()!!
        } else {
            Log.e("WeatherRepository", "Error fetching weather data: ${response.errorBody()}")
            return null
        }
    }
}