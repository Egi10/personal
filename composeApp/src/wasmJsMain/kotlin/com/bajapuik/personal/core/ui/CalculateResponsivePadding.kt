package com.bajapuik.personal.core.ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Konfigurasi padding responsif dengan max content width
 * Mengikuti pattern web design modern seperti sagarshah.dev
 */
data class ResponsiveConfig(
    val breakpoints: Map<Dp, Float> = mapOf(
        0.dp to 0.08f,     // <600dp: 8% padding
        600.dp to 0.04f,   // 600-900dp: 4% padding
        900.dp to 0.08f,   // 900-1200dp: 8% padding
        1200.dp to 0.12f   // 1200-1440dp: 12% padding
    ),
    val maxContentWidth: Dp = 1200.dp // Lebih kecil untuk better readability
)

/**
 * Menghitung padding responsif dengan mempertimbangkan max content width
 *
 * Logic:
 * 1. Jika screen width > max content width, center konten dan beri padding sisa
 * 2. Jika tidak, gunakan percentage-based padding sesuai breakpoints
 */
fun calculateResponsivePadding(
    screenWidth: Dp,
    config: ResponsiveConfig = ResponsiveConfig()
): PaddingValues {
    // Jika layar lebih besar dari max content width
    if (screenWidth > config.maxContentWidth) {
        // Center konten dengan menghitung padding sisa
        val sidePadding = (screenWidth - config.maxContentWidth) / 2
        return PaddingValues(horizontal = sidePadding)
    }

    // Gunakan percentage-based padding untuk layar lebih kecil
    val multiplier = config.breakpoints.entries
        .sortedByDescending { it.key }
        .firstOrNull { screenWidth >= it.key }?.value ?: 0.08f

    val horizontalPadding = screenWidth * multiplier
    return PaddingValues(horizontal = horizontalPadding)
}

fun Modifier.responsivePadding(
    screenWidth: Dp,
    config: ResponsiveConfig = ResponsiveConfig()
): Modifier {
    val padding = calculateResponsivePadding(screenWidth, config)
    return this.padding(padding)
}

@Composable
fun ResponsiveColumn(
    modifier: Modifier = Modifier,
    config: ResponsiveConfig = ResponsiveConfig(),
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    content: @Composable ColumnScope.() -> Unit
) {
    BoxWithConstraints(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ) {
        val screenWidth = maxWidth

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .responsivePadding(
                    screenWidth = screenWidth,
                    config = config
                ),
            horizontalAlignment = horizontalAlignment,
            verticalArrangement = verticalArrangement
        ) {
            content()
        }
    }
}

@Composable
fun ResponsiveRow(
    modifier: Modifier = Modifier,
    config: ResponsiveConfig = ResponsiveConfig(),
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    verticalAlignment: Alignment.Vertical = Alignment.Top,
    content: @Composable RowScope.() -> Unit
) {
    BoxWithConstraints(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ) {
        val screenWidth = maxWidth

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .responsivePadding(
                    screenWidth = screenWidth,
                    config = config
                ),
            horizontalArrangement = horizontalArrangement,
            verticalAlignment = verticalAlignment
        ) {
            content()
        }
    }
}