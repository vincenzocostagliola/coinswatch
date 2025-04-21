package dev.vincenzocostagliola.coinswatch.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import coil.compose.AsyncImage
import dev.vincenzocostagliola.coinswatch.R
import dev.vincenzocostagliola.data.domain.Coin


@Composable
fun OutlinedCard(item: Coin) {
    var expanded by remember { mutableStateOf(false) }
    val degrees by animateFloatAsState(if (expanded) -90f else 90f)

    Column(
        Modifier
            .fillMaxWidth()
            .padding(top = Dimens.XRegular)
    ) {
        AsyncImage(
            model = item.image,
            modifier = Modifier
                .clip(CardDefaults.outlinedShape)
                .aspectRatio(16 / 9f),
            contentScale = ContentScale.Crop,
            contentDescription = item.name
        )
        Column(Modifier.padding(start = Dimens.XRegular, end = Dimens.XRegular)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(item.name, style = MaterialTheme.typography.titleLarge)
                Spacer(Modifier.weight(1f))
                IconButton(onClick = { expanded = expanded.not() }) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.chevron_right),
                        contentDescription = if (expanded) "Hide details" else "Show more details",
                        modifier = Modifier.rotate(degrees)
                    )
                }
            }
            Spacer(Modifier.height(Dimens.XSmall))
            CreateShortInfoBox(
                expanded = expanded,
                coin = item
            )
        }
    }
}

@Composable
private fun ColumnScope.CreateShortInfoBox(expanded: Boolean, coin: Coin) {
    Box {
        this@CreateShortInfoBox.AnimatedVisibility(visible = expanded) {
            Row(
                Modifier.fillMaxWidth()
            ) {
                StartColumn(coin, Modifier.weight(weight = 1F))
                EndColumn(coin, Modifier.weight(weight = 1F))
            }
        }
    }
    this@CreateShortInfoBox.AnimatedVisibility(visible = expanded) {
        HorizontalDivider(modifier = Modifier)
    }
}

@Composable
private fun StartColumn(coin: Coin, modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(Dimens.XSmall),
        modifier = modifier.fillMaxSize()
    ) {

        Text(
            text = coin.id,
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = coin.marketCapRank.toString(),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
private fun EndColumn(coin: Coin, modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(Dimens.XSmall),
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = "Edizioni",
            style = MaterialTheme.typography.bodyLarge,
        )
        Text(
            text = "Edizioni",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "Edizioni",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "Edizioni",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
/*

@Preview
@Composable
fun CardPreview() {
    OutlinedCard()
}
*/