package shvyn22.flexingholidays.presentation

import android.os.Bundle
import android.telephony.TelephonyManager
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.collectAsState
import dagger.hilt.android.AndroidEntryPoint
import shvyn22.flexingholidays.presentation.main.MainScreen
import shvyn22.flexingholidays.presentation.ui.theme.AppTheme

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

	private val viewModel: MainViewModel by viewModels()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		val tm = getSystemService(TELEPHONY_SERVICE) as TelephonyManager
		viewModel.setCountryCode(tm.networkCountryIso)

		setContent {
			val theme = viewModel.isDarkTheme.collectAsState()

			AppTheme(
				isDarkTheme = theme.value
			) {
				MainScreen(
					viewModel = viewModel
				)
			}
		}
	}
}