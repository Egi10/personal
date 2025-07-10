package com.bajapuik.personal.core.designsystem.theme

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.bajapuik.personal.core.designsystem.utils.LocalThemeState
import com.bajapuik.personal.core.designsystem.utils.ThemeState

@Composable
fun PersonalTheme(
    windowWidthSizeClass: WindowWidthSizeClass,
    themeState: ThemeState,
    content: @Composable () -> Unit
) {
    val personalColors = if (themeState.isDarkMode) {
        PersonalColors(
            default = Color(0xFF030712),
            gray50 = Color(0xFF111827),
            gray100 = Color(0xFF1f2937),
            gray200 = Color(0xFF374151),
            gray300 = Color(0xFF4b5563),
            gray400 = Color(0xFF6b7280),
            gray500 = Color(0xFF9ca3af),
            gray600 = Color(0xFFd1d5db),
            gray700 = Color(0xFFe5e7eb),
            gray800 = Color(0xFFf3f4f6),
            gray900 = Color(0xFFf9fafb),
            gray950 = Color(0xFFffffff),
            emerald500 = Color(0xFF10b981)
        )
    } else {
        PersonalColors(
            default = Color(0xFFFFFFFF),
            gray50 = Color(0xFFF9FAFB),
            gray100 = Color(0xFFF3F4F6),
            gray200 = Color(0xFFE5E7EB),
            gray300 = Color(0xFFD1D5DB),
            gray400 = Color(0xFF9CA3AF),
            gray500 = Color(0xFF6B7280),
            gray600 = Color(0xFF4B5563),
            gray700 = Color(0xFF374151),
            gray800 = Color(0xFF1F2937),
            gray900 = Color(0xFF111827),
            gray950 = Color(0xFF030712),
            emerald500 = Color(0xFF10B981)
        )
    }

    val fontFamily = interFamily
    val personalTypography = PersonalTypography(
        headingH1 = headingH1(
            windowWidthSizeClass = windowWidthSizeClass,
            fontFamily = fontFamily
        ),
        headingH2 = headingH2(
            windowWidthSizeClass = windowWidthSizeClass,
            fontFamily = fontFamily
        ),
        headingH3 = headingH3(
            windowWidthSizeClass = windowWidthSizeClass,
            fontFamily = fontFamily
        ),
        subtitle = subtitle(
            windowWidthSizeClass = windowWidthSizeClass,
            fontFamily = fontFamily
        ),
        body1 = body1(
            windowWidthSizeClass = windowWidthSizeClass,
            fontFamily = fontFamily
        ),
        body2 = TextStyle(
            fontFamily = fontFamily,
            fontSize = 16.sp,
            lineHeight = 24.sp,
        ),
        body3 = TextStyle(
            fontFamily = fontFamily,
            fontSize = 14.sp,
            lineHeight = 20.sp,
        )
    )

    val personalElevation = PersonalElevation(
        md = 4.dp,
        lg = 8.dp,
        xl = 16.dp
    )

    CompositionLocalProvider(
        LocalPersonalColors provides personalColors,
        LocalPersonalTypography provides personalTypography,
        LocalPersonalElevation provides personalElevation,
        LocalThemeState provides themeState,
        content = content
    )
}

object PersonalTheme {
    val colors: PersonalColors
        @Composable
        get() = LocalPersonalColors.current
    val typography: PersonalTypography
        @Composable
        get() = LocalPersonalTypography.current
    val elevation: PersonalElevation
        @Composable
        get() = LocalPersonalElevation.current
}

@Composable
private fun headingH1(
    windowWidthSizeClass: WindowWidthSizeClass,
    fontFamily: FontFamily
): TextStyle {
    return when (windowWidthSizeClass) {
        WindowWidthSizeClass.Medium -> {
            TextStyle(
                fontFamily = fontFamily,
                fontSize = 48.sp,
                lineHeight = 48.sp,
                letterSpacing = (-0.02).em,
                fontWeight = FontWeight.Bold
            )
        }

        WindowWidthSizeClass.Expanded -> {
            TextStyle(
                fontFamily = fontFamily,
                fontSize = 60.sp,
                lineHeight = 72.sp,
                letterSpacing = (-0.02).em,
                fontWeight = FontWeight.Bold
            )
        }

        else -> {
            TextStyle(
                fontFamily = fontFamily,
                fontSize = 36.sp,
                lineHeight = 40.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
private fun headingH2(
    windowWidthSizeClass: WindowWidthSizeClass,
    fontFamily: FontFamily
): TextStyle {
    return when (windowWidthSizeClass) {
        WindowWidthSizeClass.Expanded -> {
            TextStyle(
                fontFamily = fontFamily,
                fontSize = 36.sp,
                lineHeight = 40.sp,
                letterSpacing = (-0.02).em,
                fontWeight = FontWeight.SemiBold
            )
        }

        else -> {
            TextStyle(
                fontFamily = fontFamily,
                fontSize = 18.sp,
                lineHeight = 28.sp,
                letterSpacing = (-0.02).em,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
private fun headingH3(
    windowWidthSizeClass: WindowWidthSizeClass,
    fontFamily: FontFamily
): TextStyle {
    return when (windowWidthSizeClass) {
        WindowWidthSizeClass.Expanded -> {
            TextStyle(
                fontFamily = fontFamily,
                fontSize = 30.sp,
                lineHeight = 36.sp,
                letterSpacing = (-0.02).em
            )
        }

        else -> {
            TextStyle(
                fontFamily = fontFamily,
                fontSize = 24.sp,
                lineHeight = 32.sp,
                letterSpacing = (-0.02).em
            )
        }
    }
}

@Composable
private fun subtitle(
    windowWidthSizeClass: WindowWidthSizeClass,
    fontFamily: FontFamily
): TextStyle {
    return when (windowWidthSizeClass) {
        WindowWidthSizeClass.Expanded -> {
            TextStyle(
                fontFamily = fontFamily,
                fontSize = 20.sp,
                lineHeight = 28.sp
            )
        }

        else -> {
            TextStyle(
                fontFamily = fontFamily,
                fontSize = 18.sp,
                lineHeight = 28.sp
            )
        }
    }
}

@Composable
private fun body1(
    windowWidthSizeClass: WindowWidthSizeClass,
    fontFamily: FontFamily
): TextStyle {
    return when (windowWidthSizeClass) {
        WindowWidthSizeClass.Expanded -> {
            TextStyle(
                fontFamily = fontFamily,
                fontSize = 18.sp,
                lineHeight = 28.sp,
                fontWeight = FontWeight.Normal
            )
        }

        else -> {
            TextStyle(
                fontFamily = fontFamily,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
}