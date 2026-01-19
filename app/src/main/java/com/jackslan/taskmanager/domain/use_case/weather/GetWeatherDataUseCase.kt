package com.jackslan.taskmanager.domain.use_case.weather

import com.jackslan.taskmanager.data.remote.model.WeatherResponse
import com.jackslan.taskmanager.domain.repository.WeatherRepository
import javax.inject.Inject

class GetWeatherDataUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {
    suspend operator fun invoke(
        coordinates: String,
        days: Int,
    ): WeatherResponse? {
        return weatherRepository.getWeatherData(
           coordinates,
            days,
        )
    }

}