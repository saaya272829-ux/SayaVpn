package com.example.sayavpn.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class ExtendedColors(
    val connectGradientStart: Color,
    val connectGradientEnd: Color,
    val connectRingSecond: Color,
    val connectRingThird: Color,
    val title: Color,
    val accentButton: Color,
    val onAccentButton: Color,
    val disabledContainer: Color,
    val disabledContent: Color,
    val navIconActive: Color,
    val navIconInactive: Color,
    val error: Color
)

val DarkExtendedColors = ExtendedColors(
    connectGradientStart = CircleGradientStart,
    connectGradientEnd = CircleGradientEnd,
    connectRingSecond = CircleSecond,
    connectRingThird = CircleThird,
    title = TitlePurple,
    accentButton = BgButton,
    onAccentButton = TextWhite,
    disabledContainer = DisabledDark,
    disabledContent = InactiveIconDark,
    navIconActive = CircleGradientStart,
    navIconInactive = InactiveIconDark,
    error = ErrorRed
)

val LightExtendedColors = ExtendedColors(
    connectGradientStart = CircleGradientStart,
    connectGradientEnd = CircleGradientEnd,
    connectRingSecond = CircleSecond,
    connectRingThird = CircleThird,
    title = TitlePurple,
    accentButton = BgButton,
    onAccentButton = TextWhite,
    disabledContainer = DisabledLight,
    disabledContent = InactiveIconLight,
    navIconActive = BgButton,
    navIconInactive = InactiveIconLight,
    error = ErrorRed
)

val LocalExtendedColors = staticCompositionLocalOf { DarkExtendedColors }
