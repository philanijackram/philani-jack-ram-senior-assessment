package com.jackslan.taskmanager.data.mappers

import com.jackslan.taskmanager.data.remote.model.WeatherResponse
import com.jackslan.taskmanager.domain.model.WeatherItem

fun WeatherResponse.toDomain(): WeatherItem {
    return WeatherItem(
        currentWeather = current.condition.text,
        sunrise = forecast.forecastday[0].astro.sunrise,
        sunset = forecast.forecastday[0].astro.sunset,
        temperature = current.tempC,
        location = location.region
    )
}