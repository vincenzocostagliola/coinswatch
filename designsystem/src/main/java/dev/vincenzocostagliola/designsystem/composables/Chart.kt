package dev.vincenzocostagliola.designsystem.composables

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview
import dev.vincenzocostagliola.designsystem.theme.Pink80
import dev.vincenzocostagliola.designsystem.theme.Purple80
import timber.log.Timber

@Composable
@Preview(heightDp = 300, widthDp = 300, backgroundColor = 0xFFFFFFFF, showBackground = true)
fun Chart(modifier: Modifier = Modifier, list: List<Float> = listOf(1f, 20f, 3f, 1f)) {
    val zipList: List<Pair<Float, Float>> = list.zipWithNext()
    Timber.d("ChartComposable - prices: $zipList")


    Row(modifier = modifier) {
        val max = list.max()
        val min = list.min()

        val lineColor =
            if (list.last() > list.first()) Purple80 else Pink80

        for (pair in zipList) {

            val fromValuePercentage = getValuePercentageForRange(pair.first, max, min)
            val toValuePercentage = getValuePercentageForRange(pair.second, max, min)

            Canvas(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                onDraw = {
                    val fromPoint = Offset(x = 0f, y = size.height.times(1 - fromValuePercentage))
                    val toPoint =
                        Offset(x = size.width, y = size.height.times(1 - toValuePercentage))

                    drawLine(
                        color = lineColor,
                        start = fromPoint,
                        end = toPoint,
                        strokeWidth = 3f
                    )
                })
        }
    }
}

private fun getValuePercentageForRange(value: Float, max: Float, min: Float) =
    (value - min) / (max - min)