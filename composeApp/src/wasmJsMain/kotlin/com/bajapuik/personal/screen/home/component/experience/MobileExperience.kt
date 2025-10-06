package com.bajapuik.personal.screen.home.component.experience

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.PlatformContext
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.bajapuik.personal.core.designsystem.component.PersonalTags
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme
import com.bajapuik.personal.domain.model.Experience
import org.jetbrains.compose.resources.painterResource
import personal.composeapp.generated.resources.Res
import personal.composeapp.generated.resources.img_avatar

@Composable
internal fun MobileExperience(
    experiences: List<Experience>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PersonalTags(
            text = "Experience"
        )

        Spacer(
            modifier = Modifier
                .height(16.dp)
        )

        Text(
            text = "Here are a few of the projects I've worked on recently:",
            style = PersonalTheme.typography.subtitle,
            color = PersonalTheme.colors.gray600,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier
                .height(24.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(
                space = 24.dp
            )
        ) {
            experiences.forEach {
                MobileExperienceItem(
                    item = it
                )
            }
        }
    }
}

@Composable
private fun MobileExperienceItem(
    item: Experience,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .dropShadow(
                shape = RoundedCornerShape(12.dp),
                block = {
                    offset = Offset(
                        x = 0f,
                        y = 4f
                    )
                    brush = SolidColor(
                        value = Color(0xFF000000).copy(
                            alpha = 0.15f
                        )
                    )
                    radius = 3f
                }
            )
            .background(
                color = PersonalTheme.colors.default,
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    all = 32.dp
                ),
            verticalArrangement = Arrangement.spacedBy(
                space = 16.dp
            )
        ) {
            AsyncImage(
                model = ImageRequest.Builder(PlatformContext.INSTANCE)
                    .data(item.company)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(Res.drawable.img_avatar),
                contentDescription = null,
                modifier = Modifier
                    .size(
                        width = 102.dp,
                        height = 28.dp
                    )
            )

            Text(
                text = "${item.startDate} - ${item.endDate}",
                style = PersonalTheme.typography.body2,
                color = PersonalTheme.colors.gray700
            )

            Text(
                text = item.position,
                style = PersonalTheme.typography.subtitle,
                color = PersonalTheme.colors.gray900,
                fontWeight = FontWeight.SemiBold
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(
                    space = 4.dp
                )
            ) {
                item.descriptions.forEach {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "•",
                            style = PersonalTheme.typography.body2,
                            color = PersonalTheme.colors.gray600
                        )

                        Spacer(
                            modifier = Modifier
                                .width(8.dp)
                        )

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