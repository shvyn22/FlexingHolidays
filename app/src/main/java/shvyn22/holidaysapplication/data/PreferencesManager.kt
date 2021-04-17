package shvyn22.holidaysapplication.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

data class Prefs(val nightMode: Boolean)

@Singleton
class PreferencesManager @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {

    val preferencesFlow = dataStore.data.map {
        val nightMode = it[PreferencesKeys.NIGHT_MODE] ?: false
        Prefs(nightMode)
    }

    suspend fun editNightMode(nightMode: Boolean) {
        dataStore.edit {
            it[PreferencesKeys.NIGHT_MODE] = nightMode
        }
    }

    private object PreferencesKeys {
        val NIGHT_MODE = booleanPreferencesKey("nightMode")
    }
}