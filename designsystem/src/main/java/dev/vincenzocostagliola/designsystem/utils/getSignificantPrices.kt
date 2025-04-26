package dev.vincenzocostagliola.designsystem.utils

fun List<Float>.getSignificantPrices(): List<Float> {
    if (this.isEmpty()) return emptyList()

    val sorted = this.sorted()
    val min = sorted.first()
    val max = sorted.last()

    return if (min == max) {
        // all values are the same
        List(10) { min }
    } else {
        val step = (sorted.size - 1) / 9.0  // 9 steps between 10 values
        (List(10) { i ->
            val index = (i * step).toInt().coerceIn(0, sorted.lastIndex)
            sorted[index]
        })
    }
}