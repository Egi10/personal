package com.bajapuik.personal.screen.home.component.testimonials

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bajapuik.personal.core.designsystem.component.PersonalTags
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme
import com.bajapuik.personal.core.ui.ResponsiveColumn
import com.bajapuik.personal.domain.model.Testimonial

@Composable
fun DesktopTestimonials(
    testimonials: List<Testimonial>,
    modifier: Modifier = Modifier
) {
    ResponsiveColumn(
        modifier = modifier
            .padding(
                horizontal = 32.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PersonalTags(
            text = "Testimonials"
        )

        Spacer(
            modifier = Modifier
                .height(16.dp)
        )

        Text(
            text = "Nice things people have said about me:",
            style = PersonalTheme.typography.subtitle,
            color = PersonalTheme.colors.gray600
        )

        Spacer(
            modifier = Modifier
                .height(48.dp)
        )

        Row(
            modifier = Modifier
                .horizontalScroll(
                    state = rememberScrollState()
                )
                .padding(
                    horizontal = 32.dp
                )
                .height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.spacedBy(
                space = 48.dp
            )
        ) {
            testimonials.forEach {
                TestimonialItem(
                    modifier = Modifier
                        .width(373.33.dp)
                        .fillMaxHeight(),
                    item = it
                )
            }
        }
    }
}