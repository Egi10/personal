package com.bajapuik.personal.screen.root.event

sealed interface RootEvent {
    data class InitDartMode(val default: Boolean) : RootEvent
    data class SetDarkMode(val isDark: Boolean) : RootEvent
}