package com.bajapuik.personal

import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme
import com.bajapuik.personal.di.initModule
import com.bajapuik.personal.screen.home.HomeScreen
import org.koin.compose.KoinApplication

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun App() {
    val windowSizeClass = calculateWindowSizeClass()
    val widthSizeClass = windowSizeClass.widthSizeClass

    KoinApplication(
        application = {
            modules(initModule)
        }
    ) {
        PersonalTheme(
            windowWidthSizeClass = widthSizeClass
        ) {
            HomeScreen(
                windowWidthSizeClass = widthSizeClass
            )
        }
    }
}