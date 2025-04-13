package com.bajapuik.personal.screen.home.component.experience

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bajapuik.personal.core.designsystem.component.PersonalTags
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme
import com.bajapuik.personal.core.ui.calculateResponsivePadding
import com.bajapuik.personal.core.ui.shadowMd
import com.bajapuik.personal.data.experience.Experience
import org.jetbrains.compose.resources.painterResource

@Composable
fun DesktopExperience(
    experiences: List<Experience>,
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

        BoxWithConstraints(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {
            /**
             * TODO : Adjust layout margins to match the web design at https://sagarshah.dev/
             * On larger screens, the margins are still inconsistent
             * Review the responsive layout rules and ensure a consistent max content width
             */
            val breakpoints = mapOf(
                0.dp to 0.13f,
                600.dp to 0.00f,
                900.dp to 0.08f,
                1000.dp to 0.13f,
            )

            val horizontalPadding = calculateResponsivePadding(
                columnWidth = maxWidth,
                breakpoints = breakpoints,
                defaultMultiplier = 0.13f
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = horizontalPadding
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
}

@Composable
private fun ExperienceItem(
    item: Experience,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .shadowMd(
                shadowColor = PersonalTheme.colors.gray200.copy(
                    alpha = 0.8f
                ),
                borderRadius = 12.dp
            )
            .background(
                color = PersonalTheme.colors.default,
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
                Image(
                    painter = painterResource(item.company),
                    contentDescription = null,
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