package dev.vincenzocostagliola.designsystem.utils

import java.text.NumberFormat
import java.util.Locale

fun List<Float>.formatPricesAsEuro(): List<String> {
    val format = NumberFormat.getCurrencyInstance(Locale.ITALY)
    return this.map { format.format(it) }
}