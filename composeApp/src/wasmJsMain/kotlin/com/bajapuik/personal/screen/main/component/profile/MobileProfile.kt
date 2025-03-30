package com.bajapuik.personal.screen.main.component.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme
import com.bajapuik.personal.core.ui.BlinkingAvailabilityStatus
import com.bajapuik.personal.core.ui.MobileProfileImage
import com.bajapuik.personal.core.ui.Platform
import com.bajapuik.personal.data.personal.Personal
import org.jetbrains.compose.resources.painterResource
import personal.composeapp.generated.resources.Res
import personal.composeapp.generated.resources.ic_location

@Composable
fun MobileProfile(
    personal: Personal,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MobileProfileImage(
            width = 280.dp,
            height = 300.dp,
            borderColor = PersonalTheme.colors.default,
            modifier = Modifier
                .padding(
                    horizontal = 31.5.dp
                )
        )

        Spacer(
            modifier = Modifier
                .height(48.dp)
        )

        MobileProfileInfo(
            personal = personal
        )
    }
}

@Composable
private fun MobileProfileInfo(
    personal: Personal,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "Hi, I'm ${personal.fullName}",
            style = PersonalTheme.typography.headingH1,
            color = PersonalTheme.colors.gray900,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(
            modifier = Modifier
                .height(8.dp)
        )

        Text(
            text = personal.summary,
            style = PersonalTheme.typography.body2,
            color = PersonalTheme.colors.gray600
        )

        Spacer(
            modifier = Modifier
                .height(48.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                space = 8.dp
            )
        ) {
            Icon(
                painter = painterResource(Res.drawable.ic_location),
                contentDescription = personal.address,
                tint = PersonalTheme.colors.gray600,
                modifier = Modifier
                    .size(24.dp)
            )

            Text(
                text = personal.address,
                style = PersonalTheme.typography.body2,
                color = PersonalTheme.colors.gray600
            )
        }

        Spacer(
            modifier = Modifier
                .height(8.dp)
        )

        BlinkingAvailabilityStatus()

        Spacer(
            modifier = Modifier
                .height(48.dp)
        )

        Platform(
            github = personal.github,
            medium = personal.medium,
            linkedIn = personal.linkedIn
        )
    }
}