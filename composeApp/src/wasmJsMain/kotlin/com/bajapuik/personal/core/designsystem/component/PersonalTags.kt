package com.bajapuik.personal.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme

@Composable
fun PersonalTags(
    text: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(
                color = PersonalTheme.colors.gray200,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(
                vertical = 4.dp,
                horizontal = 20.dp
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = PersonalTheme.typography.body3,
            color = PersonalTheme.colors.gray600,
            fontWeight = FontWeight.Medium
        )
    }
}