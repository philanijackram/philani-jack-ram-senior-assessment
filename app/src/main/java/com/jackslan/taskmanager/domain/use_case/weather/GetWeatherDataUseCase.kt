package com.jackslan.taskmanager.domain.use_case.weather

import com.jackslan.taskmanager.data.remote.model.WeatherResponse
import com.jackslan.taskmanager.domain.repository.WeatherRepository
import javax.inject.Inject

class GetWeatherDataUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {
    suspend operator fun invoke(
        latitude: Double,
        longitude: Double,
        days: Int,
    ): WeatherResponse {
        return weatherRepository.getWeatherData(
            latitude,
            longitude,
            days,
        )
    }

}