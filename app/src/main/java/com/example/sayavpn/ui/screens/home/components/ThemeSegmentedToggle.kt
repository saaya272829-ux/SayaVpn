package com.example.sayavpn.ui.screens.home.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sayavpn.ui.theme.FastikTheme

@Composable
fun ThemeSegmentedToggle(
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = CircleShape,
        color = MaterialTheme.colorScheme.surface
    ) {
        Row(
            modifier = Modifier.padding(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val lightBgColor by animateColorAsState(
                targetValue = if (!isDarkTheme) FastikTheme.colors.connectGradientStart else Color.Transparent,
                animationSpec = tween(300),
                label = "lightBg"
            )
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(lightBgColor)
                    .clickable { if (isDarkTheme) onToggleTheme() }
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Светлая",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = if (!isDarkTheme) Color.White else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }

            val darkBgColor by animateColorAsState(
                targetValue = if (isDarkTheme) FastikTheme.colors.connectGradientStart else Color.Transparent,
                animationSpec = tween(300),
                label = "darkBg"
            )
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(darkBgColor)
                    .clickable { if (!isDarkTheme) onToggleTheme() }
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Тёмная",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = if (isDarkTheme) Color.White else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }
        }
    }
}
