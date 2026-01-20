package com.jackslan.taskmanager.presentation.features.home.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jackslan.taskmanager.R
import com.jackslan.taskmanager.presentation.theme.Typography
import com.jackslan.taskmanager.utils.AstroType

@Composable
fun AstroCard(
    modifier: Modifier = Modifier,
    astroType: AstroType = AstroType.SUNRISE,
    time: String = stringResource(R.string.time_placeholder)

) {
    Card(
        modifier = modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(
                    when (astroType) {
                        AstroType.SUNRISE -> {
                            R.drawable.sunrise_icon
                        }

                        AstroType.SUNSET -> {
                            R.drawable.sunset_icon
                        }

                    }
                ),
                contentDescription = stringResource(R.string.sunset_icon)
            )

            Text(
                style = Typography.bodyMedium,
                modifier = Modifier.padding(vertical = 4.dp),
                text = astroType.value
            )

            Text(
                text = time,
                style = Typography.bodyMedium,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AstroCardPreview() {
    AstroCard()
}