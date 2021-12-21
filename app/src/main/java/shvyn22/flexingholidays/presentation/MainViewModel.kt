package shvyn22.flexingholidays.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import shvyn22.flexingholidays.data.local.model.Holiday
import shvyn22.flexingholidays.data.preferences.PreferencesManager
import shvyn22.flexingholidays.repository.Repository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
    private val preferences: PreferencesManager
) : ViewModel() {

    val prefs = preferences.preferencesFlow

    fun getHolidays(code: String) = flow {
        emit(repository.getHolidays(code))
    }

    val favoriteHolidays = flow {
        repository.getFavoriteHolidays().collect {
            emit(it)
        }
    }

    fun onAddToFavorite(item: Holiday) = viewModelScope.launch {
        repository.addFavorite(item)
    }

    fun onRemoveFromFavorite(item: Holiday) = viewModelScope.launch {
        repository.deleteFavorite(item)
    }

    fun isFavoriteItem(id: String) = flow {
        repository.isFavorite(id).collect {
            emit(it)
        }
    }

    fun onToggleMode(newValue: Boolean) = viewModelScope.launch {
        preferences.editNightMode(newValue)
    }
}