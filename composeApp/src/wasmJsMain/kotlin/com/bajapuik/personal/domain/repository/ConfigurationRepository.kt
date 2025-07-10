package com.bajapuik.personal.domain.repository

interface ConfigurationRepository {
    suspend fun setDarkMode(isDark: Boolean)
    suspend fun getDarkMode(default: Boolean = false): Boolean
}