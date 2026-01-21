package com.jackslan.taskmanager.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.jackslan.taskmanager.presentation.theme.Dimens
import com.jackslan.taskmanager.presentation.theme.Typography
import com.jackslan.taskmanager.utils.ToDoFilterOptions

@Preview(showBackground = true)
@PreviewLightDark
@Composable
fun FilterPills(
    selectedOption: String = ToDoFilterOptions.ALL.value,
    onFilterChange: (String) -> Unit = {},
    filterOptions: List<String> = ToDoFilterOptions.entries.map { it.value }
) {

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(Dimens.smallPadding),
        horizontalArrangement = Arrangement.spacedBy(Dimens.mediumPadding)
    ) {
        items(filterOptions) { filterOption ->
            val isSelected = filterOption == selectedOption
            Card(
                modifier = Modifier
                    .padding(Dimens.smallPadding)
                    .border(
                        Dimens.borderSize,
                        MaterialTheme.colorScheme.primary,
                        RoundedCornerShape(Dimens.largePadding)
                    )
                    .shadow(Dimens.smallPadding, RoundedCornerShape(Dimens.largePadding))
                    .clickable { onFilterChange(filterOption) },
                colors = CardDefaults.cardColors(
                    containerColor = if (isSelected) {
                        MaterialTheme.colorScheme.secondary
                    } else {
                        MaterialTheme.colorScheme.primary
                    },
                    contentColor = if (isSelected) {
                        MaterialTheme.colorScheme.onSecondary
                    } else {
                        MaterialTheme.colorScheme.onPrimary
                    }
                ),
                elevation = CardDefaults.cardElevation(Dimens.pillElevation)

            ) {
                Box(
                    modifier = Modifier
                        .padding(Dimens.mediumPadding)

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