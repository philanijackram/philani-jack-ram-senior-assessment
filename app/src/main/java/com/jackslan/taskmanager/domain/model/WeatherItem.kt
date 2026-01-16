package com.jackslan.taskmanager.domain.model

data class WeatherItem(
    val id: Int,
    val astroItem: AstroItem,
    val currentWeather: String

)

data class AstroItem(
    val id: Int,
    val sunrise: String,
    val sunset: String,
    val moonrise: String,
    val moonset: String,
    val moonPhase: String,
    val moonIllumination: Int
)

val dummyWeatherData = WeatherItem(
    id = 1,
    astroItem = AstroItem(
        id = 1,
        sunrise = "7:00 AM",
        sunset = "4:00 PM",
        moonrise = "7:00 AM",
        moonset = "4:00 PM",
        moonPhase = "Full",
        moonIllumination = 100
    ),
    currentWeather = "19 C"

)