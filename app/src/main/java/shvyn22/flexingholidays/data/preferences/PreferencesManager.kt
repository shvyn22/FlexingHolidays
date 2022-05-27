package shvyn22.flexingholidays.data.preferences

import kotlinx.coroutines.flow.Flow

interface PreferencesManager {

    val isDarkTheme: Flow<Boolean>

    suspend fun editThemePreferences(newThemeValue: Boolean)
}