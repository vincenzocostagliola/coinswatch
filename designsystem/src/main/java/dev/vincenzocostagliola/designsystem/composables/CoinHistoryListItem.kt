package dev.vincenzocostagliola.designsystem.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import dev.vincenzocostagliola.data.domain.CoinHistoricalData.PriceChartPoint
import org.threeten.bp.format.DateTimeFormatter.ISO_DATE

@Composable
fun CoinShortInfoListItem(history: PriceChartPoint) {
        Column {
            ListItem(
                headlineContent = { Text(history.date.format(ISO_DATE)) },
                supportingContent = { Text(history.value.toString()) }
            )
            HorizontalDivider()

        }
    }
