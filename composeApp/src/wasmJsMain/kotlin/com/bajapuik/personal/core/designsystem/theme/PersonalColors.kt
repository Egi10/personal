package com.bajapuik.personal.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class PersonalColors(
    val default: Color,
    val gray50: Color,
    val gray100: Color,
    val gray200: Color,
    val gray300: Color,
    val gray400: Color,
    val gray500: Color,
    val gray600: Color,
    val gray700: Color,
    val gray800: Color,
    val gray900: Color,
    val gray950: Color,
    val emerald500: Color
)

val LocalPersonalColors = staticCompositionLocalOf {
    PersonalColors(
        default = Color.Unspecified,
        gray50 = Color.Unspecified,
        gray100 = Color.Unspecified,
        gray200 = Color.Unspecified,
        gray300 = Color.Unspecified,
        gray400 = Color.Unspecified,
        gray500 = Color.Unspecified,
        gray600 = Color.Unspecified,
        gray700 = Color.Unspecified,
        gray800 = Color.Unspecified,
        gray900 = Color.Unspecified,
        gray950 = Color.Unspecified,
        emerald500 = Color.Unspecified
    )
}
