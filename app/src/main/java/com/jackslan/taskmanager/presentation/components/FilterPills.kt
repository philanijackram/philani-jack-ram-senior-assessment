package com.jackslan.taskmanager.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jackslan.taskmanager.presentation.theme.Typography

@Preview(showBackground = true)
@Composable
fun FilterPills(
    darkMode: Boolean = false,
    selectedOption: String = "ALL",
    onFilterChange: (String) -> Unit = {},
    filterOptions: List<String> = listOf("ALL", "TO DO", "COMPLETED")
) {

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(4.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(filterOptions) { filterOption ->
            val isSelected = filterOption == selectedOption
            Card(
                modifier = Modifier
                    .padding(4.dp)
                    .border(1.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(16.dp))
                    .shadow(4.dp, RoundedCornerShape(16.dp))
                    .clickable { onFilterChange(filterOption) },
                colors = CardDefaults.cardColors(
                    containerColor = if (isSelected) {
                        if (!darkMode) Color(0xFF5E5D5D) else Color(0xFFFDFDFD)
                    } else {
                        if (!darkMode) Color(0xFFFDFDFD) else Color(0xFF5E5D5D)
                    },
                    contentColor = if (isSelected) {
                        if (!darkMode) Color.White else Color.Black
                    } else {
                        if (!darkMode) Color.Black else Color.White
                    }
                ),
                elevation = CardDefaults.cardElevation(2.dp)

            ) {
                Box(
                    modifier = Modifier
                        .padding(8.dp)

                ) {
                    Text(
                        text = filterOption,
                        style = Typography.bodyMedium
                    )
                }
            }
        }
    }
}