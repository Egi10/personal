package com.bajapuik.personal.screen.main.component.testimonials

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bajapuik.personal.core.designsystem.component.PersonalTags
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme
import com.bajapuik.personal.data.tertimonials.Testimonial

@Composable
internal fun MobileTestimonials(
    testimonials: List<Testimonial>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
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
            testimonials.forEach {
                TestimonialItem(
                    item = it,
                )
            }
        }
    }
}