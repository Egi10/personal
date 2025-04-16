package com.bajapuik.personal.screen.home.component.getintouch

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bajapuik.personal.core.designsystem.component.PersonalIconButtons
import com.bajapuik.personal.core.designsystem.component.PersonalTags
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme
import com.bajapuik.personal.core.ui.Platform
import com.bajapuik.personal.core.utils.Clipboard
import com.bajapuik.personal.domain.model.Personal
import org.jetbrains.compose.resources.painterResource
import personal.composeapp.generated.resources.Res
import personal.composeapp.generated.resources.ic_copy
import personal.composeapp.generated.resources.ic_email
import personal.composeapp.generated.resources.ic_telp

@Composable
internal fun GetInTouch(
    personal: Personal,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PersonalTags(
            text = "Get in touch"
        )

        Spacer(
            modifier = Modifier
                .height(16.dp)
        )

        Text(
            text = "What’s next? Feel free to reach out to me if you're looking for a developer, have a query, or simply want to connect.",
            style = PersonalTheme.typography.subtitle,
            color = PersonalTheme.colors.gray600,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier
                .height(48.dp)
        )

        PersonalItem(
            value = personal.email,
            icon = painterResource(Res.drawable.ic_email)
        )

        Spacer(
            modifier = Modifier
                .height(16.dp)
        )

        PersonalItem(
            value = personal.phoneNumber,
            icon = painterResource(Res.drawable.ic_telp)
        )

        Spacer(
            modifier = Modifier
                .height(48.dp)
        )

        Text(
            text = "You may also find me on these platforms!",
            style = PersonalTheme.typography.subtitle,
            color = PersonalTheme.colors.gray600,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier
                .height(8.dp)
        )

        Platform(
            item = personal.socialMedia
        )
    }
}

@Composable
private fun PersonalItem(
    value: String,
    icon: Painter,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(
            space = 20.dp
        )
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            tint = PersonalTheme.colors.gray600
        )

        Text(
            text = value,
            style = PersonalTheme.typography.headingH2,
            color = PersonalTheme.colors.gray900,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .weight(
                    weight = 1f,
                    fill = false
                )
        )

        PersonalIconButtons(
            icon = painterResource(Res.drawable.ic_copy),
            tint = PersonalTheme.colors.gray600,
            onClick = {
                Clipboard.copy(
                    text = value
                )
            }
        )
    }
}