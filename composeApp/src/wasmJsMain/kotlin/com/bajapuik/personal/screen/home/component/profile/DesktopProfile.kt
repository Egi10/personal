package com.bajapuik.personal.screen.home.component.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.PlatformContext
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme
import com.bajapuik.personal.core.ui.BlinkingAvailabilityStatus
import com.bajapuik.personal.core.ui.Platform
import com.bajapuik.personal.domain.model.Personal
import org.jetbrains.compose.resources.painterResource
import personal.composeapp.generated.resources.Res
import personal.composeapp.generated.resources.ic_location
import personal.composeapp.generated.resources.img_avatar

@Composable
internal fun DesktopProfile(
    personal: Personal,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(
                horizontal = 32.dp
            )
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = "Hi, I'm ${personal.fullName}",
                style = PersonalTheme.typography.headingH1,
                color = PersonalTheme.colors.gray900
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
                item = personal.socialMedia
            )
        }

        Spacer(
            modifier = Modifier
                .width(128.dp)
        )

        ProfileImage(
            image = personal.image
        )
    }
}

@Composable
private fun ProfileImage(
    image: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(
                width = 320.dp,
                height = 360.dp
            )
    ) {
        Box(
            modifier = Modifier
                .size(
                    width = 280.dp,
                    height = 320.dp
                )
                .border(
                    width = 8.dp,
                    color = PersonalTheme.colors.default
                )
                .background(
                    color = PersonalTheme.colors.gray200
                )
                .align(
                    alignment = Alignment.BottomEnd
                )
        )

        AsyncImage(
            model = ImageRequest.Builder(PlatformContext.INSTANCE)
                .data(image)
                .crossfade(true)
                .build(),
            placeholder = painterResource(Res.drawable.img_avatar),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(
                    width = 280.dp,
                    height = 320.dp
                )
                .border(
                    width = 8.dp,
                    color = PersonalTheme.colors.default
                )
                .background(
                    color = PersonalTheme.colors.emerald500
                )

                .align(
                    alignment = Alignment.TopStart
                ),
        )
    }
}