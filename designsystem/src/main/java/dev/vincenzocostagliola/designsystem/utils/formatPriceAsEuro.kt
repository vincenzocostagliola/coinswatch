package dev.vincenzocostagliola.designsystem.utils

import java.text.NumberFormat
import java.util.Locale

fun Double.formatPriceAsEuro(): String {
    val formatter = NumberFormat.getCurrencyInstance(Locale.ITALY)
    return formatter.format(this)
}