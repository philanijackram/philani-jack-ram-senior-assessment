package com.jackslan.taskmanager.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jackslan.taskmanager.domain.model.WeatherItem
import com.jackslan.taskmanager.domain.model.dummyWeatherData
import com.jackslan.taskmanager.utils.AstroType
import com.jackslan.taskmanager.utils.DateUtils
import java.time.LocalDate
import java.util.Date
import kotlin.time.Duration.Companion.days

@Composable
fun WeatherSection(
    modifier: Modifier = Modifier,
    weatherItem: WeatherItem? = dummyWeatherData
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 8.dp),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column() {
                Text(
                    text = DateUtils.getTodayDay(),
                    style = typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
                Text(text = DateUtils.getTodayDate(), modifier = Modifier.padding(vertical = 8.dp))
                Text(weatherItem?.location ?: "")
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = if (weatherItem?.temperature != null) " ${weatherItem.temperature}" else "--",
                    style = typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = weatherItem?.currentWeather ?: "--",
                    style = typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
            }

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {


            AstroCard(
                modifier = Modifier.weight(1f),
                astroType = AstroType.SUNRISE,
                time = weatherItem?.sunrise ?: "--:--"

            )
            AstroCard(
                modifier = Modifier.weight(1f),
                astroType = AstroType.SUNSET,
                time = weatherItem?.sunset ?: "--:--"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherPreview() {
    WeatherSection()
}