package com.bajapuik.personal.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PersonalIconButtons(
    icon: Painter,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    tint: Color = PersonalTheme.colors.gray600
) {
    var isHovered by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = modifier
            .size(36.dp)
            .background(
                color = if (isHovered) {
                    PersonalTheme.colors.gray100
                } else {
                    Color.Transparent
                },
                shape = RoundedCornerShape(8.dp)
            )
            .onPointerEvent(PointerEventType.Enter) { isHovered = true }
            .onPointerEvent(PointerEventType.Exit) { isHovered = false }
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        onClick.invoke()
                    }
                )
            },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            tint = tint,
            modifier = Modifier
                .size(24.dp)
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PersonalIconButtons(
    icon: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var isHovered by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = modifier
            .size(36.dp)
            .background(
                color = if (isHovered) {
                    PersonalTheme.colors.gray100
                } else {
                    Color.Transparent
                },
                shape = RoundedCornerShape(8.dp)
            )
            .onPointerEvent(PointerEventType.Enter) { isHovered = true }
            .onPointerEvent(PointerEventType.Exit) { isHovered = false }
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        onClick.invoke()
                    }
                )
            },
        contentAlignment = Alignment.Center
    ) {
        PersonalImage(
            url = icon,
            colorFilter = ColorFilter.tint(
                color = PersonalTheme.colors.gray600
            ),
            modifier = Modifier
                .size(24.dp)
        )
    }
}