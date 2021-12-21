package shvyn22.flexingholidays.presentation.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val yellow = Color(0xFFFFFE00)
val orange = Color(0xFFFF7F00)
val capri = Color(0xFF01BFFF)
val springBud = Color(0xFFA7FC01)

val black900 = Color(0xFF1C1C1C)
val black800 = Color(0xFF3C3C3C)
val white100 = Color(0xFFFAFAFA)

val LightColors = lightColors(
    primary = Color.White,
    primaryVariant = white100,
    onPrimary = black900,
    secondary = black800,
    background = white100,
    onBackground = black900
)

val DarkColors = darkColors(
    primary = black900,
    primaryVariant = black800,
    onPrimary = Color.White,
    secondary = white100,
    background = black800,
    onBackground = Color.White
)