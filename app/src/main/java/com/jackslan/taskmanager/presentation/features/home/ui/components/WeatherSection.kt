package com.jackslan.taskmanager.presentation.features.home.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.jackslan.taskmanager.R
import com.jackslan.taskmanager.domain.model.WeatherItem
import com.jackslan.taskmanager.domain.model.dummyWeatherData
import com.jackslan.taskmanager.presentation.theme.Dimens
import com.jackslan.taskmanager.presentation.theme.Typography
import com.jackslan.taskmanager.utils.AstroType
import com.jackslan.taskmanager.utils.DateUtils

@Composable
fun WeatherSection(
    weatherItem: WeatherItem? = dummyWeatherData
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Dimens.mediumPadding),
        elevation = CardDefaults.cardElevation(Dimens.cardElevation)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Dimens.largePadding),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = DateUtils.getTodayDay(),
                    style = Typography.titleLarge
                )

                Text(
                    text = DateUtils.getTodayDate(),
                    style = Typography.bodyLarge,
                    modifier = Modifier.padding(vertical = Dimens.mediumPadding)
                )

                Text(
                    text = weatherItem?.location ?: "",
                    style = Typography.bodyLarge
                )

            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = if (weatherItem?.temperature != null) stringResource(
                        R.string.degree_celcius,
                        weatherItem.temperature
                    ) else stringResource(
                        R.string.textfield_placeholder
                    ),
                    style = Typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = weatherItem?.currentWeather
                        ?: stringResource(R.string.textfield_placeholder),
                    style = Typography.bodyLarge,
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = Dimens.mediumPadding),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            AstroCard(
                modifier = Modifier.weight(1f),
                astroType = AstroType.SUNRISE,
                time = weatherItem?.sunrise ?: stringResource(R.string.time_placeholder_)

            )
            AstroCard(
                modifier = Modifier.weight(1f),
                astroType = AstroType.SUNSET,
                time = weatherItem?.sunset ?: stringResource(R.string.time_placeholder_)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherPreview() {
    WeatherSection()
}