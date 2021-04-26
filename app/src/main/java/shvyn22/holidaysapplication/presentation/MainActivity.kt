package shvyn22.holidaysapplication.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import shvyn22.holidaysapplication.presentation.ui.theme.HolidayTheme

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val themeState = viewModel.prefs.collectAsState(initial = false)
            val theme by remember { themeState }

            HolidayTheme(
                isDarkTheme = theme
            ) {
                MainScreen(
                    viewModel = viewModel,
                    isDarkTheme = theme)
            }
        }
    }
}