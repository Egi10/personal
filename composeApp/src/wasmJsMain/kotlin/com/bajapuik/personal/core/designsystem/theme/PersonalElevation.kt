package com.bajapuik.personal.core.designsystem.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp

data class PersonalElevation(
    val md: Dp,
    val lg: Dp,
    val xl: Dp
)

val LocalPersonalElevation = staticCompositionLocalOf {
    PersonalElevation(
        md = Dp.Unspecified,
        lg = Dp.Unspecified,
        xl = Dp.Unspecified
    )
}
