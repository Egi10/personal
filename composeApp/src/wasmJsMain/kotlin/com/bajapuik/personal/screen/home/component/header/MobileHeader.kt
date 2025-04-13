package com.bajapuik.personal.screen.home.component.header

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.bajapuik.personal.core.designsystem.component.PersonalIconButtons
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme
import org.jetbrains.compose.resources.painterResource
import personal.composeapp.generated.resources.Res
import personal.composeapp.generated.resources.ic_burger

@Composable
fun MobileHeader(
    onMenuClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "<JSN/>",
            style = PersonalTheme.typography.headingH3,
            color = PersonalTheme.colors.gray900,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .weight(1f)
        )

        PersonalIconButtons(
            icon = painterResource(Res.drawable.ic_burger),
            onClick = onMenuClick
        )
    }
}