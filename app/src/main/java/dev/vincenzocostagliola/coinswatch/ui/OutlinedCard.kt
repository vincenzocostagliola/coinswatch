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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import dev.vincenzocostagliola.data.domain.Coin
import org.threeten.bp.LocalDate

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
            model = item.shortInfo.coverImageUrl,
            modifier = Modifier
                .clip(CardDefaults.outlinedShape)
                .aspectRatio(16 / 9f),
            contentScale = ContentScale.Crop,
            contentDescription = item.shortInfo.title
        )
        Column(Modifier.padding(start = Dimens.XRegular, end = Dimens.XRegular)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(item.shortInfo.title, style = MaterialTheme.typography.titleLarge)
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
                shortInfo = item.shortInfo
            )
        }
    }
}

@Composable
private fun ColumnScope.CreateShortInfoBox(expanded: Boolean, shortInfo: ShortInfo) {
    Box {
        this@CreateShortInfoBox.AnimatedVisibility(visible = expanded) {
            Row(
                Modifier.fillMaxWidth()
            ) {
                StartColumn(shortInfo, Modifier.weight(weight = 1F))
                EndColumn(shortInfo, Modifier.weight(weight = 1F))
            }
        }
    }
    this@CreateShortInfoBox.AnimatedVisibility(visible = expanded) {
        HorizontalDivider(modifier = Modifier)
    }
}

@Composable
private fun StartColumn(shortInfo: ShortInfo, modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(Dimens.XSmall),
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(R.string.album_number),
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = shortInfo.number?.let {
                it.toString()
            } ?: stringResource(R.string.no_value),
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = stringResource(R.string.periodicity),
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = shortInfo.periodicity.name,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
private fun EndColumn(shortInfo: ShortInfo, modifier: Modifier) {
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


@Preview
@Composable
fun CardPreview() {
    OutlinedCard(getFakeAlbum())
}

fun getFakeAlbum(): CollectionItem.DylanDog {
    return CollectionItem.DylanDog(
        shortInfo = ShortInfo(
            number = 10,
            coverImageUrl = "https://shop.sergiobonelli.it/resizer/1000/-1/true/1601882082011.png--dylan_dog_oldboy_3_cover.png?1601882082000",
            title = "Dylan Dog Oldboy 3",
            periodicity = Details.Periodicity.BIMESTRALE,
            summary = "cose da raccontare"
        ), details = Details(
            team = Details.Team(
                subject = listOf("Simeoni Gigi", "Marzano Giancarlo"),
                script = listOf("Simeoni Gigi", "Marzano Giancarlo"),
                illustrations = listOf(
                    "Simeoni Gigi",
                    "Camagni Giulio"
                ),
                cover = listOf(
                    "Cestaro Raul",
                    "Cestaro Gianluca"
                )
            ), album = Details.Album(
                format = "16x21 cm, b/n",
                pages = 192,
                isbn = "977182645204500100",
                dateOfPublishing = LocalDate.now(),
                albumUrl = "https://shop.sergiobonelli.it/dylan-dog/2020/08/26/albo/dylan-dog-oldboy-3-1008607/"
            )
        ), id = 9990
    )
}
