package shvyn22.holidaysapplication.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import shvyn22.holidaysapplication.presentation.ui.theme.HolidayTheme

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HolidayTheme(
                isDarkTheme = viewModel.isDarkMode.value
            ) {
                MainScreen(
                    viewModel = viewModel,
                    isDarkTheme = viewModel.isDarkMode.value)
            }
        }
    }
}