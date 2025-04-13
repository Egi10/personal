package com.bajapuik.personal.screen.home.component.footer

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme

@Composable
internal fun Footer(
    name: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
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
    }
}