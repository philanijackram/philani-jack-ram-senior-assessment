package com.jackslan.taskmanager.data.remote.api

import com.jackslan.taskmanager.data.remote.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v1/forecast.json")
    suspend fun getWeatherData(
        @Query("q") coordinates: String,
        @Query("days") days: Int,
        @Query("key") apiKey: String,
        @Query("alerts") alerts: String = "no"
    ): Response<WeatherResponse>
}