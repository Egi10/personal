package com.bajapuik.personal.screen.main.component.aboutme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bajapuik.personal.core.designsystem.component.PersonalTags
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme
import com.bajapuik.personal.core.ui.MobileProfileImage
import com.bajapuik.personal.data.personal.Personal

@Composable
fun MobileAboutMe(
    personal: Personal,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PersonalTags(
            text = "About Me"
        )

        Spacer(
            modifier = Modifier
                .height(24.dp)
        )

        MobileProfileImage(
            width = 320.dp,
            height = 380.dp,
            borderColor = PersonalTheme.colors.gray50,
            modifier = Modifier
                .padding(
                    horizontal = 11.5.dp
                )
        )

        Spacer(
            modifier = Modifier
                .height(48.dp)
        )

        Text(
            text = "Curious about me? Here you have it:",
            style = PersonalTheme.typography.headingH3,
            color = PersonalTheme.colors.gray900,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier
                .height(24.dp)
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(
                space = 16.dp
            )
        ) {
            personal.aboutMe.forEach {
                Text(
                    text = it,
                    style = PersonalTheme.typography.body2,
                    color = PersonalTheme.colors.gray600
                )
            }
        }
    }
}