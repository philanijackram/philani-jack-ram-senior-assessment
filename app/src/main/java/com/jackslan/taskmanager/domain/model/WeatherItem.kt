package com.jackslan.taskmanager.domain.model

data class WeatherItem(
    val sunrise: String,
    val sunset: String,
    val currentWeather: String,
    val temperature: Double,
    val location: String
)

val dummyWeatherData = WeatherItem(
    sunrise = "7:00 AM",
    sunset = "4:00 PM",
    currentWeather = "Partly Cloudy",
    temperature = 19.5,
    location = "Gauteng"
)