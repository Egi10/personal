package com.bajapuik.personal.screen.home.component.aboutme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bajapuik.personal.core.designsystem.component.PersonalTags
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme
import com.bajapuik.personal.data.personal.Personal
import org.jetbrains.compose.resources.painterResource
import personal.composeapp.generated.resources.Res
import personal.composeapp.generated.resources.img_profile

@Composable
fun DesktopAboutMe(
    personal: Personal,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(
                horizontal = 32.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PersonalTags(
            text = "About Me"
        )

        Spacer(
            modifier = Modifier
                .height(48.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(
                space = 48.dp
            )
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                ProfileImageAboutMe()
            }


            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = "Curious about me? Here you have it:",
                    style = PersonalTheme.typography.headingH3,
                    color = PersonalTheme.colors.gray900,
                    fontWeight = FontWeight.SemiBold
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
    }
}

@Composable
private fun ProfileImageAboutMe(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(
                width = 440.dp,
                height = 520.dp
            )
    ) {
        Box(
            modifier = Modifier
                .size(
                    width = 400.dp,
                    height = 480.dp
                )
                .border(
                    width = 8.dp,
                    color = PersonalTheme.colors.gray50
                )
                .background(
                    color = PersonalTheme.colors.gray200
                )
                .align(
                    alignment = Alignment.BottomStart
                )
        )

        Image(
            modifier = Modifier
                .size(
                    width = 400.dp,
                    height = 480.dp
                )
                .border(
                    width = 8.dp,
                    color = PersonalTheme.colors.gray50
                )
                .background(
                    color = PersonalTheme.colors.emerald500
                )
                .align(
                    alignment = Alignment.TopEnd
                ),
            painter = painterResource(Res.drawable.img_profile),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}