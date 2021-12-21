package shvyn22.flexingholidays.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.collectAsState
import dagger.hilt.android.AndroidEntryPoint
import shvyn22.flexingholidays.presentation.main.MainScreen
import shvyn22.flexingholidays.presentation.ui.theme.HolidayTheme

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            val theme = viewModel.prefs.collectAsState(initial = false)

            HolidayTheme(
                isDarkTheme = theme.value
            ) {
                MainScreen(
                    viewModel = viewModel,
                    isDarkTheme = theme.value
                )
            }
        }
    }
}