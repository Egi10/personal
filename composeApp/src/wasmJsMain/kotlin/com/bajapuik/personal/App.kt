package com.bajapuik.personal

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme
import com.bajapuik.personal.core.designsystem.utils.ThemeState
import com.bajapuik.personal.di.initModule
import com.bajapuik.personal.screen.home.HomeScreen
import org.koin.compose.KoinApplication

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun App() {
    val windowSizeClass = calculateWindowSizeClass()
    val widthSizeClass = windowSizeClass.widthSizeClass

    val systemDarkMode = isSystemInDarkTheme()
    val isDarkMode = remember { mutableStateOf(systemDarkMode) }

    val themeState = rememberUpdatedState(
        newValue = ThemeState(
            isDarkMode = isDarkMode.value,
            toggleTheme = { isDarkMode.value = !isDarkMode.value }
        )
    )

    KoinApplication(
        application = {
            modules(initModule)
        }
    ) {
        PersonalTheme(
            windowWidthSizeClass = widthSizeClass,
            themeState = themeState.value
        ) {
            HomeScreen(
                windowWidthSizeClass = widthSizeClass
            )
        }
    }
}