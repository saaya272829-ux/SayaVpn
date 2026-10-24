package com.example.sayavpn.ui.screens.home.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Wifi
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.example.sayavpn.core.constants.Dimens
import com.example.sayavpn.ui.theme.FastikTheme

@Composable
fun VpnConnectButton(
    isConnected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val pressScale by animateFloatAsState(
        targetValue = if (isPressed) 0.94f else 1f,
        animationSpec = tween(durationMillis = 120),
        label = "pressScale"
    )

    val buttonBrush = if (isConnected) {
        Brush.linearGradient(
            listOf(
                FastikTheme.colors.connectGradientStart,
                FastikTheme.colors.connectGradientEnd
            )
        )
    } else {
        Brush.linearGradient(
            listOf(
                FastikTheme.colors.disabledContainer,
                FastikTheme.colors.disabledContainer
            )
        )
    }

    Box(
        modifier = modifier
            .size(Dimens.ConnectButtonSize)
            .graphicsLayer {
                scaleX = pressScale
                scaleY = pressScale
            }
            .clip(CircleShape)
            .background(buttonBrush)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {

        Icon(
            imageVector = Icons.Filled.Wifi,
            contentDescription = null,
            tint = if (isConnected) Color.White else FastikTheme.colors.disabledContent,
            modifier = Modifier.size(56.dp)
        )
    }
}
