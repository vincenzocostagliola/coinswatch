package dev.vincenzocostagliola.designsystem.utils

import java.text.NumberFormat
import java.util.Locale

fun formatPricesAsEuro(prices: List<Float>): List<String> {
    val format = NumberFormat.getCurrencyInstance(Locale.ITALY)
    return prices.map { format.format(it) }
}