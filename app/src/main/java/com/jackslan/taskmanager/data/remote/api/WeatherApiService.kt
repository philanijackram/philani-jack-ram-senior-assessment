package com.jackslan.taskmanager.data.remote.api


import com.jackslan.taskmanager.data.remote.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {

    @GET("v1/forecast.json")
    suspend fun getWeatherData(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("days") days: Int,
        @Query("key") apiKey: String
    ): WeatherResponse
}