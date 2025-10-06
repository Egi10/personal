package com.bajapuik.personal.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bajapuik.personal.core.designsystem.component.PersonalImage
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme

@Composable
fun MobileProfileImage(
    image: String,
    width: Dp,
    height: Dp,
    borderColor: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(
                width = width,
                height = height
            )
    ) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .padding(
                    top = 20.dp
                )
                .border(
                    width = 8.dp,
                    color = borderColor
                )
                .background(
                    color = PersonalTheme.colors.gray200
                )
        )

        PersonalImage(
            url = image,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .matchParentSize()
                .padding(
                    bottom = 20.dp,
                    start = 20.5.dp,
                    end = 19.5.dp
                )
                .border(
                    width = 8.dp,
                    color = borderColor
                ),
        )
    }
}