package com.bajapuik.personal.screen.home.component.testimonials

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bajapuik.personal.core.designsystem.component.PersonalTags
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme
import com.bajapuik.personal.domain.model.Testimonial
import org.jetbrains.compose.resources.stringResource
import personal.composeapp.generated.resources.Res
import personal.composeapp.generated.resources.testimonials
import personal.composeapp.generated.resources.testimonials_subtitle

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
            text = stringResource(Res.string.testimonials)
        )

        Spacer(
            modifier = Modifier
                .height(16.dp)
        )

        Text(
            text = stringResource(Res.string.testimonials_subtitle),
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