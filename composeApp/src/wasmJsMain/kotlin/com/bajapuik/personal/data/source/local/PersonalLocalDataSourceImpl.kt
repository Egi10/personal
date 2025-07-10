package com.bajapuik.personal.data.source.local

import com.russhwolf.settings.Settings
import com.russhwolf.settings.set

class PersonalLocalDataSourceImpl(
    private val settings: Settings
): PersonalLocalDataSource {
    override suspend fun saveDarkMode(isDark: Boolean) {
        settings[KEY_DARK_MODE] = isDark
    }

    override suspend fun getDarkMode(default: Boolean): Boolean {
        return settings.getBoolean(KEY_DARK_MODE, default)
    }

    companion object Companion {
        const val KEY_DARK_MODE = "dark_mode"
    }
}