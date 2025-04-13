package com.bajapuik.personal.screen.home.component.work.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme

enum class WorkItemLayoutType { IMAGE_LEFT, IMAGE_RIGHT }

@Composable
fun Modifier.imageDesktop(
    isImageLeft: Boolean
): Modifier {
    return Modifier
        .drawBehind {
            val borderWidth = 1.dp.toPx()
            val x = if (isImageLeft) size.width else 0f
            drawLine(
                color = Color(0xFFF3F4F6),
                start = Offset(x, 0f),
                end = Offset(x, size.height),
                strokeWidth = borderWidth
            )
        }
        .background(
            color = PersonalTheme.colors.gray50,
            shape = RoundedCornerShape(
                topStart = if (isImageLeft) 12.dp else 0.dp,
                bottomStart = if (isImageLeft) 12.dp else 0.dp,
                topEnd = if (isImageLeft) 0.dp else 12.dp,
                bottomEnd = if (isImageLeft) 0.dp else 12.dp
            )
        )
        .padding(48.dp)
}