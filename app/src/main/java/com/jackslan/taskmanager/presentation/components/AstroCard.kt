package com.jackslan.taskmanager.presentation.components

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
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jackslan.taskmanager.R
import com.jackslan.taskmanager.utils.AstroType
import java.util.Locale


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
                modifier = Modifier.padding(vertical = 8.dp),
                text = astroType.name.lowercase(Locale.ROOT)
                    .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
            )

            Text(
                text = time
            )


        }
    }
}

@Preview(showBackground = true)
@Composable
fun AstroCardPreview() {
    AstroCard()
}