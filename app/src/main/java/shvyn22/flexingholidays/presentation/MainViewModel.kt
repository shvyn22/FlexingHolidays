package shvyn22.flexingholidays.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import shvyn22.flexingholidays.data.local.model.HolidayModel
import shvyn22.flexingholidays.data.preferences.PreferencesManager
import shvyn22.flexingholidays.repository.Repository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
    private val preferences: PreferencesManager
) : ViewModel() {

    private var countryCode = "us"

    val isDarkTheme = preferences.isDarkTheme
        .stateIn(viewModelScope, SharingStarted.Lazily, false)

    val holidays = flow {
        repository.getHolidays(countryCode).collect {
            emit(it)
        }
    }.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    val favoriteHolidays = flow {
        repository.getFavoriteHolidays().collect {
            emit(it)
        }
    }.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun setCountryCode(code: String) {
        countryCode = code
    }

    fun isHolidayFavorite(id: String) = flow {
        repository.isHolidayFavorite(id).collect {
            emit(it)
        }
    }

    fun insertFavoriteHoliday(item: HolidayModel) {
        viewModelScope.launch {
            repository.insertFavoriteHoliday(item)
        }
    }

    fun deleteFavoriteHoliday(item: HolidayModel) {
        viewModelScope.launch {
            repository.deleteFavoriteHoliday(item)
        }
    }

    fun editThemePreferences(newThemeValue: Boolean) {
        viewModelScope.launch {
            preferences.editThemePreferences(newThemeValue)
        }
    }
}