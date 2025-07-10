package com.bajapuik.personal.data.repository.configuration

import com.bajapuik.personal.data.source.local.PersonalLocalDataSource
import com.bajapuik.personal.domain.repository.ConfigurationRepository

class ConfigurationRepositoryImpl(
    private val personalLocalDataSource: PersonalLocalDataSource
): ConfigurationRepository {
    override suspend fun setDarkMode(isDark: Boolean) {
        personalLocalDataSource.saveDarkMode(
            isDark = isDark
        )
    }

    override suspend fun getDarkMode(default: Boolean): Boolean {
        return personalLocalDataSource.getDarkMode(
            default = default
        )
    }
}