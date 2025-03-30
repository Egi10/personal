package com.bajapuik.personal.screen.main.component.testimonials

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme
import com.bajapuik.personal.core.ui.shadowMd
import com.bajapuik.personal.data.tertimonials.Testimonial
import org.jetbrains.compose.resources.painterResource
import personal.composeapp.generated.resources.Res
import personal.composeapp.generated.resources.img_avatar

@Composable
internal fun TestimonialItem(
    item: Testimonial,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues =  PaddingValues(
        all = 32.dp
    )
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
            .padding(
                paddingValues = contentPadding
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(
                space = 24.dp
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(Res.drawable.img_avatar),
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
            )

            Text(
                text = "\"${item.message}\"",
                style = PersonalTheme.typography.body2,
                color = PersonalTheme.colors.gray600,
            )

            ProfileTestimonial(
                name = item.name,
                role = item.role,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
private fun ProfileTestimonial(
    name: String,
    role: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(
            space = 4.dp
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = name,
            style = PersonalTheme.typography.subtitle,
            color = PersonalTheme.colors.gray900
        )

        Text(
            text = role,
            style = PersonalTheme.typography.body3,
            color = PersonalTheme.colors.gray600
        )
    }
}