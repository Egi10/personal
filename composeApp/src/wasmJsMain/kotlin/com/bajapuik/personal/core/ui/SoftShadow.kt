package com.bajapuik.personal.core.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * A more accurate implementation with multiple layers to simulate blur
 */
@Composable
fun Modifier.shadowMd(
    shadowColor: Color = Color(0f, 0f, 0f, 0.08f), // Alpha diperhalus
    borderRadius: Dp = 0.dp
) = this.drawBehind {
    val cornerRadius = androidx.compose.ui.geometry.CornerRadius(borderRadius.toPx())

    // First shadow layer: 0 3px 5px -1px (offsetY dikurangi)
    val firstLayerBlurRadius = 5.dp.toPx() // Blur dikurangi
    val firstLayerOffsetY = 3.dp.toPx() // Offset Y dikurangi dari 4dp ke 3dp
    val firstLayerSpread = -1.dp.toPx()

    for (i in 0..3) { // Sub-layer dikurangi
        val alpha = shadowColor.alpha * (4 - i) / 12f // Distribusi alpha lebih transparan
        val blurAmount = firstLayerBlurRadius * (i + 1) / 4f

        drawRoundRect(
            color = shadowColor.copy(alpha = alpha),
            topLeft = Offset(
                x = -firstLayerSpread - blurAmount,
                y = firstLayerOffsetY - firstLayerSpread - (blurAmount * 0.8f) // Reduksi efek vertikal
            ),
            size = Size(
                width = size.width + 2 * (firstLayerSpread + blurAmount),
                height = size.height + 2 * (firstLayerSpread + blurAmount * 0.7f) // Reduksi ekspansi vertikal
            ),
            cornerRadius = cornerRadius
        )
    }

    // Second shadow layer: 0 1px 3px -2px (offsetY dikurangi drastis)
    val secondLayerBlurRadius = 3.dp.toPx()
    val secondLayerOffsetY = 1.dp.toPx() // Offset Y dikurangi dari 2dp ke 1dp
    val secondLayerSpread = -2.dp.toPx()

    for (i in 0..2) {
        val alpha = shadowColor.alpha * (3 - i) / 9f
        val blurAmount = secondLayerBlurRadius * (i + 1) / 3f

        drawRoundRect(
            color = shadowColor.copy(alpha = alpha),
            topLeft = Offset(
                x = -secondLayerSpread - blurAmount,
                y = secondLayerOffsetY - secondLayerSpread - (blurAmount * 0.6f) // Reduksi vertikal lebih kuat
            ),
            size = Size(
                width = size.width + 2 * (secondLayerSpread + blurAmount),
                height = size.height + 2 * (secondLayerSpread + blurAmount * 0.5f) // Ekspansi vertikal minimal
            ),
            cornerRadius = cornerRadius
        )
    }
}