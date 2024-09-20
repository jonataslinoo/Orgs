package br.com.jonatas.emg.extensions

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

fun BigDecimal.formatBrazilianCurrency(): String {
    val format = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
    return format.format(this)
}