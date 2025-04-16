package com.bajapuik.personal.screen.home.utils

import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * TODO : Add Effect Blur
 */
fun Modifier.glassBackground(
    isScrolled: Boolean,
    color: Color,
    dividerColor: Color,
    blurSimulationAlpha: Float = 0.95f,
    isDesktop: Boolean = false
): Modifier = composed {
    this
        .background(
            color = color.copy(
                alpha = if (isScrolled) blurSimulationAlpha else 0f
            )
        )
        .drawBehind {
            if (isScrolled && isDesktop) {
                drawLine(
                    color = dividerColor,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = 1.dp.toPx()
                )
            }
        }
}