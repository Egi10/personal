package com.bajapuik.personal.screen.home.component.footer

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.unit.dp
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme
import com.bajapuik.personal.core.ui.ResponsiveColumn
import org.jetbrains.compose.resources.stringResource
import personal.composeapp.generated.resources.Res
import personal.composeapp.generated.resources.footer_by_and_coded_with
import personal.composeapp.generated.resources.footer_copyright
import personal.composeapp.generated.resources.footer_designed
import personal.composeapp.generated.resources.footer_made_with

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
                append(stringResource(Res.string.footer_copyright))
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
                    append(stringResource(Res.string.footer_designed))
                }
                append(stringResource(Res.string.footer_by_and_coded_with, name))
            },
            style = PersonalTheme.typography.body2,
            color = PersonalTheme.colors.gray600,
            textAlign = TextAlign.Center
        )

        Text(
            text = stringResource(Res.string.footer_made_with),
            style = PersonalTheme.typography.body2,
            color = PersonalTheme.colors.gray600,
            textAlign = TextAlign.Center
        )
    }
}