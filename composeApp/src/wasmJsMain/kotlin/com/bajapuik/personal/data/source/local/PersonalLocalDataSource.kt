package com.bajapuik.personal.data.source.local

interface PersonalLocalDataSource {
    suspend fun saveDarkMode(isDark: Boolean)
    suspend fun getDarkMode(default: Boolean = false): Boolean
    suspend fun setLanguage(language: String)
    suspend fun getLanguage(default: String = "en"): String
}