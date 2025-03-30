package com.bajapuik.personal.core.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bajapuik.personal.core.designsystem.component.PersonalIconButtons
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme
import kotlinx.browser.window
import org.jetbrains.compose.resources.painterResource
import personal.composeapp.generated.resources.Res
import personal.composeapp.generated.resources.ic_github
import personal.composeapp.generated.resources.ic_linkedin
import personal.composeapp.generated.resources.ic_medium

@Composable
fun Platform(
    github: String,
    medium: String,
    linkedIn: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(
            space = 4.dp
        )
    ) {
        PersonalIconButtons(
            icon = painterResource(Res.drawable.ic_github),
            tint = PersonalTheme.colors.gray600,
            onClick = {
                window.open(github, "_blank")
            }
        )

        PersonalIconButtons(
            icon = painterResource(Res.drawable.ic_medium),
            tint = PersonalTheme.colors.gray600,
            onClick = {
                window.open(medium, "_blank")
            }
        )

        PersonalIconButtons(
            icon = painterResource(Res.drawable.ic_linkedin),
            tint = PersonalTheme.colors.gray600,
            onClick = {
                window.open(linkedIn, "_blank")
            }
        )
    }
}