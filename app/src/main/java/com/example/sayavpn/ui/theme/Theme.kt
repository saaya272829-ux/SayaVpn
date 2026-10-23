package com.example.sayavpn.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = CircleGradientStart,
    onPrimary = TextWhite,
    secondary = CircleSecond,
    background = BgMainDark,
    onBackground = TextWhite,
    surface = BgMenuDark,
    onSurface = TextWhite,
    surfaceVariant = BgMenuDark,
    onSurfaceVariant = TextWhite,
    error = ErrorRed
)

private val LightColorScheme = lightColorScheme(
    primary = BgButton,
    onPrimary = TextWhite,
    secondary = CircleSecond,
    background = BgMainLight,
    onBackground = TextBlack,
    surface = BgMenuLight,
    onSurface = TextBlack,
    surfaceVariant = BgMenuLight,
    onSurfaceVariant = TextBlack,
    error = ErrorRed
)

@Composable
fun SayaVpnTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val extendedColors = if (darkTheme) DarkExtendedColors else LightExtendedColors

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window, view).apply {
                isAppearanceLightStatusBars = !darkTheme
                isAppearanceLightNavigationBars = !darkTheme
            }
        }
    }

    CompositionLocalProvider(LocalExtendedColors provides extendedColors) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}

object FastikTheme {
    val colors: ExtendedColors
        @Composable
        get() = LocalExtendedColors.current
}
