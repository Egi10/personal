package com.bajapuik.personal.core.ui

import androidx.compose.ui.unit.Dp

fun calculateResponsivePadding(
    columnWidth: Dp,
    breakpoints: Map<Dp, Float>,
    defaultMultiplier: Float
): Dp {
    // Cari breakpoint yang paling cocok dengan `columnWidth`
    val selectedMultiplier = breakpoints.entries
        .sortedByDescending { it.key } // Urutkan dari terbesar ke terkecil
        .firstOrNull { columnWidth >= it.key }?.value ?: defaultMultiplier

    return (columnWidth * selectedMultiplier)
}