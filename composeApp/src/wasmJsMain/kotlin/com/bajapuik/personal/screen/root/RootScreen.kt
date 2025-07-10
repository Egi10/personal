package com.bajapuik.personal.screen.root

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme
import com.bajapuik.personal.core.designsystem.utils.ThemeState
import com.bajapuik.personal.screen.home.HomeScreen
import com.bajapuik.personal.screen.root.event.RootEvent
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
internal fun RootScreen(
    modifier: Modifier = Modifier,
    viewModel: RootViewModel = koinViewModel()
) {
    val windowSizeClass = calculateWindowSizeClass()
    val widthSizeClass = windowSizeClass.widthSizeClass

    val systemDarkMode = isSystemInDarkTheme()

    LaunchedEffect(Unit) {
        viewModel.onEvent(
            event = RootEvent.InitDartMode(
                default = systemDarkMode
            )
        )
    }

    val themeState = rememberUpdatedState(
        newValue = ThemeState(
            isDarkMode = viewModel.isDarkMode,
            toggleTheme = {
                viewModel.onEvent(
                    event = RootEvent.SetDarkMode(
                        isDark = !viewModel.isDarkMode
                    )
                )
            }
        )
    )

    PersonalTheme(
        windowWidthSizeClass = widthSizeClass,
        themeState = themeState.value
    ) {
        HomeScreen(
            modifier = modifier,
            windowWidthSizeClass = widthSizeClass
        )
    }
}