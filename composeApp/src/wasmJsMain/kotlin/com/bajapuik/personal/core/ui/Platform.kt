package com.bajapuik.personal.core.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bajapuik.personal.core.designsystem.component.PersonalIconButtons
import com.bajapuik.personal.domain.model.SocialMedia
import kotlinx.browser.window

@Composable
fun Platform(
    item: List<SocialMedia>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(
            space = 4.dp
        )
    ) {
        item.forEach {
            PersonalIconButtons(
                icon = it.platform,
                onClick = {
                    window.open(it.url, "_blank")
                }
            )
        }
    }
}