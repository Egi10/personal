package com.bajapuik.personal.core.designsystem.utils

import androidx.compose.runtime.compositionLocalOf

class ThemeState(
    val isDarkMode: Boolean,
    val toggleTheme: () -> Unit
)

val LocalThemeState = compositionLocalOf<ThemeState> {
    error("ThemeState not provided!")
}