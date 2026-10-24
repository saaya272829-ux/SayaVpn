package com.example.sayavpn.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.sayavpn.R
import com.example.sayavpn.core.constants.Dimens
import com.example.sayavpn.ui.screens.home.components.ConnectionStatusText
import com.example.sayavpn.ui.screens.home.components.ThemeSegmentedToggle
import com.example.sayavpn.ui.screens.home.components.VpnConnectButton
import com.example.sayavpn.ui.theme.FastikTheme
import com.example.sayavpn.ui.theme.SayaVpnTheme

@Composable
fun HomeScreen(
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit,
    modifier: Modifier = Modifier
) {
    var isConnected by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(Dimens.ScreenPadding)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = Dimens.SpacingM),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineMedium,
                color = FastikTheme.colors.title,
                fontWeight = FontWeight.Bold
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            VpnConnectButton(
                isConnected = isConnected,
                onClick = { isConnected = !isConnected }
            )

            Spacer(modifier = Modifier.height(Dimens.SpacingL))

            ConnectionStatusText(isConnected = isConnected)

            Spacer(modifier = Modifier.height(Dimens.SpacingXl))

            ThemeSegmentedToggle(
                isDarkTheme = isDarkTheme,
                onToggleTheme = onToggleTheme
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenDarkPreview() {
    SayaVpnTheme(darkTheme = true) {
        HomeScreen(isDarkTheme = true, onToggleTheme = {})
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenLightPreview() {
    SayaVpnTheme(darkTheme = false) {
        HomeScreen(isDarkTheme = false, onToggleTheme = {})
    }
}
