package shvyn22.holidaysapplication.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import shvyn22.holidaysapplication.data.PreferencesManager
import shvyn22.holidaysapplication.data.model.Holiday
import shvyn22.holidaysapplication.repository.AppRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: AppRepository,
    private val preferences: PreferencesManager
): ViewModel(){

    val prefs = preferences.preferencesFlow

    val holidays = mutableStateOf<List<Holiday>>(listOf())
    val favoriteHolidays = mutableStateOf<List<Holiday>>(listOf())

    init {
        viewModelScope.launch {
            holidays.value = repository.getHolidays()
            repository.getFavoriteHolidays().collect {
                favoriteHolidays.value = it
            }
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