package com.jackslan.taskmanager.data.remote.model

import kotlinx.serialization.Serializable



@Serializable
data class WeatherResponse(
    val location: Location,
    val current: CurrentWeather,
    val forecast: Forecast
) {

    @Serializable
    data class Location(
        val name: String,
        val region: String,
        val country: String,
        val lat: Double,
        val lon: Double,
        val localtime: String
    )

    @Serializable
    data class CurrentWeather(
        val temp_c: Double,
        val feelslike_c: Double,
        val is_day: Int,
        val humidity: Int,
        val uv: Double,
        val wind_kph: Double,
        val condition: Condition
    )

    @Serializable
    data class Forecast(
        val forecastday: List<ForecastDay>
    )

    @Serializable
    data class ForecastDay(
        val date: String,
        val day: Day,
        val astro: Astro
    )

    @Serializable
    data class Day(
        val maxtemp_c: Double,
        val mintemp_c: Double,
        val avgtemp_c: Double,
        val daily_chance_of_rain: Int,
        val uv: Double,
        val condition: Condition
    )

    @Serializable
    data class Astro(
        val sunrise: String,
        val sunset: String,
        val moonrise: String,
        val moonset: String,
        val moon_phase: String,
        val moon_illumination: Int
    )

    @Serializable
    data class Condition(
        val text: String,
        val icon: String,
        val code: Int
    )
}

