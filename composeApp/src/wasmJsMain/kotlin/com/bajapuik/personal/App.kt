package com.bajapuik.personal

import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.runtime.Composable
import com.bajapuik.personal.di.initModule
import com.bajapuik.personal.screen.root.RootScreen
import org.koin.compose.KoinApplication

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun App() {
    KoinApplication(
        application = {
            modules(initModule)
        }
    ) {
        RootScreen()
    }
}