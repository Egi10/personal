package com.bajapuik.personal.core.ui

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme

@Composable
fun BlinkingAvailabilityStatus() {
    val infiniteTransition = rememberInfiniteTransition()
    val primaryColor = Color(0xFF10B981)

    // Animasi untuk efek ripple
    val ripple1 by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 1600
                0.0f at 0
                1.0f at 1600
            },
            repeatMode = RepeatMode.Restart
        )
    )

    // Animasi untuk 3 lapis ripple
    fun getRippleValues(progress: Float) = listOf(
        progress,
        (progress - 0.3f).coerceIn(0f, 1f),
        (progress - 0.6f).coerceIn(0f, 1f)
    )


    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(24.dp),
            contentAlignment = Alignment.Center
        ) {
            // Background ripple effect
            getRippleValues(ripple1).forEach { progress ->
                Canvas(
                    modifier = Modifier
                        .fillMaxSize()
                        .graphicsLayer {
                            alpha = 1 - progress
                            scaleX = 1 + progress * 1.5f
                            scaleY = 1 + progress * 1.5f
                        }
                ) {
                    drawCircle(
                        color = primaryColor.copy(alpha = 0.2f * (1 - progress)),
                        radius = size.minDimension * 0.3f
                    )
                }
            }

            // Main circle (static)
            Canvas(modifier = Modifier.size(12.dp)) {
                drawCircle(
                    color = primaryColor,
                    radius = size.minDimension / 2
                )
            }
        }

        Text(
            text = "Available for work",
            style = PersonalTheme.typography.body2,
            color = PersonalTheme.colors.gray600
        )
    }
}