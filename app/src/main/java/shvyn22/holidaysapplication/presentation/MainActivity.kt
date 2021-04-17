package shvyn22.holidaysapplication.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import shvyn22.holidaysapplication.presentation.ui.theme.HolidayTheme

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launchWhenCreated {
            viewModel.prefs.collect {
                setContent {
                    HolidayTheme(
                        isDarkTheme = it.nightMode
                    ) {
                        MainScreen(
                            viewModel = viewModel,
                            isDarkTheme = it.nightMode)
                    }
                }
            }
        }
    }
}