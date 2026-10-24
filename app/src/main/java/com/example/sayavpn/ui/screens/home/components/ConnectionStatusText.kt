package com.example.sayavpn.ui.screens.home.components

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun ConnectionStatusText(
    isConnected: Boolean,
    modifier: Modifier = Modifier
) {
    Crossfade(
        targetState = isConnected,
        animationSpec = tween(durationMillis = 300),
        modifier = modifier,
        label = "statusText"
    ) { connected ->
        Text(
            text = if (connected) "Подключено" else "Отключено",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center
        )
    }
}
