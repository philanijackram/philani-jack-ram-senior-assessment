package com.jackslan.taskmanager.data.remote.model

import com.google.gson.annotations.SerializedName
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
        @SerializedName("temp_c")
        val tempC: Double,
        @SerializedName("feelslike_c")
        val feelsLikeC: Double,
        @SerializedName("is_day")
        val isDay: Int,
        val humidity: Int,
        val uv: Double,
        @SerializedName("wind_kph")
        val windKph: Double,
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
        @SerializedName("maxtemp_c")
        val maxTempC: Double,
        @SerializedName("mintemp_c")
        val minTempC: Double,
        @SerializedName("avgtemp_c")
        val avgTempC: Double,
        @SerializedName("daily_chance_of_rain")
        val dailyChanceOfRain: Int,
        val uv: Double,
        val condition: Condition
    )

    @Serializable
    data class Astro(
        val sunrise: String,
        val sunset: String,
        val moonrise: String,
        val moonset: String,
        @SerializedName("moon_phase")
        val moonPhase: String,
        @SerializedName("moon_illumination")
        val moonIllumination: Int
    )

    @Serializable
    data class Condition(
        val text: String,
        val icon: String,
        val code: Int
    )
}

