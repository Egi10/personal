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
import com.bajapuik.personal.core.designsystem.component.PersonalImage
import com.bajapuik.personal.core.designsystem.component.PersonalTags
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme
import com.bajapuik.personal.core.ui.ResponsiveColumn
import com.bajapuik.personal.domain.model.Experience

@Composable
fun DesktopExperience(
    experiences: List<Experience>,
    modifier: Modifier = Modifier
) {
    ResponsiveColumn(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PersonalTags(
            text = "Experience",
        )

        Spacer(
            modifier = Modifier
                .height(16.dp)
        )

        Text(
            text = "Here is a quick summary of my most recent experiences:",
            textAlign = TextAlign.Center,
            style = PersonalTheme.typography.subtitle,
            color = PersonalTheme.colors.gray600
        )

        Spacer(
            modifier = Modifier
                .height(48.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 150.dp
                ),
            verticalArrangement = Arrangement.spacedBy(
                space = 48.dp
            )
        ) {
            experiences.forEach {
                ExperienceItem(
                    item = it
                )
            }
        }
    }
}

@Composable
private fun ExperienceItem(
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
                color = PersonalTheme.colors.gray100,
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    all = 32.dp
                ),
            horizontalArrangement = Arrangement.spacedBy(
                space = 48.dp
            )
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                PersonalImage(
                    url = item.company,
                    modifier = Modifier
                        .size(
                            width = 102.dp,
                            height = 28.dp
                        )
                )
            }

            Column(
                modifier = Modifier
                    .weight(2f)
            ) {
                Text(
                    text = item.position,
                    style = PersonalTheme.typography.subtitle,
                    fontWeight = FontWeight.SemiBold,
                    color = PersonalTheme.colors.gray900
                )

                Spacer(
                    modifier = Modifier
                        .height(16.dp)
                )

                Column(
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

            Text(
                text = "${item.startDate} - ${item.endDate ?: "Present"}",
                style = PersonalTheme.typography.body2,
                color = PersonalTheme.colors.gray700
            )
        }
    }
}