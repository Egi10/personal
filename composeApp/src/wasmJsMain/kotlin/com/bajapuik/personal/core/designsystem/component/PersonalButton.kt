package com.bajapuik.personal.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PersonalButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var isHovered by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = modifier
            .height(36.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(
                color = if (!isHovered) {
                    PersonalTheme.colors.gray900
                } else {
                    PersonalTheme.colors.gray700
                },
                shape = RoundedCornerShape(12.dp)
            )
            .onPointerEvent(PointerEventType.Enter) { isHovered = true }
            .onPointerEvent(PointerEventType.Exit) { isHovered = false }
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        onClick.invoke()
                    }
                )
            }
            .padding(
                horizontal = 16.dp,
                vertical = 6.dp
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = PersonalTheme.typography.body2,
            fontWeight = FontWeight.Medium,
            color = PersonalTheme.colors.gray50
        )
    }
}