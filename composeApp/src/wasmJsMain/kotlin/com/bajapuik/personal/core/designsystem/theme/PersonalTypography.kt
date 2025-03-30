package com.bajapuik.personal.core.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import personal.composeapp.generated.resources.Res
import personal.composeapp.generated.resources.inter_bold
import personal.composeapp.generated.resources.inter_medium
import personal.composeapp.generated.resources.inter_regular
import personal.composeapp.generated.resources.inter_semi_bold

data class PersonalTypography(
    val headingH1: TextStyle,
    val headingH2: TextStyle,
    val headingH3: TextStyle,
    val subtitle: TextStyle,
    val body1: TextStyle,
    val body2: TextStyle,
    val body3: TextStyle
)

val LocalPersonalTypography = staticCompositionLocalOf {
    PersonalTypography(
        headingH1 = TextStyle.Default,
        headingH2 = TextStyle.Default,
        headingH3 = TextStyle.Default,
        subtitle = TextStyle.Default,
        body1 = TextStyle.Default,
        body2 = TextStyle.Default,
        body3 = TextStyle.Default
    )
}

internal val interFamily: FontFamily
    @Composable
    get() = FontFamily(
        Font(
            resource = Res.font.inter_regular,
            weight = FontWeight.Normal,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.inter_medium,
            weight = FontWeight.Medium,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.inter_semi_bold,
            weight = FontWeight.SemiBold,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.inter_bold,
            weight = FontWeight.Bold,
            style = FontStyle.Normal
        ),
    )