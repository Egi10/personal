package com.bajapuik.personal.screen.home.component.footer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme
import com.bajapuik.personal.core.ui.ResponsiveColumn

@Composable
internal fun Footer(
    name: String,
    modifier: Modifier = Modifier
) {
    ResponsiveColumn(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = 4.dp
        )
    ) {
        Text(
            text = buildAnnotatedString {
                append("© 2025 | ")
                withLink(
                    link = LinkAnnotation.Url(
                        url = "https://www.figma.com/community/file/1262992249991763120",
                        styles = TextLinkStyles(
                            style = SpanStyle(
                                textDecoration = TextDecoration.Underline
                            )
                        )
                    ),
                ) {
                    append("Designed")
                }
                append(" by Sagar Shah and coded with $name")
            },
            style = PersonalTheme.typography.body2,
            color = PersonalTheme.colors.gray600,
            textAlign = TextAlign.Center
        )

        Text(
            text = "Made with Compose Multiplatform",
            style = PersonalTheme.typography.body2,
            color = PersonalTheme.colors.gray600,
            textAlign = TextAlign.Center
        )
    }
}