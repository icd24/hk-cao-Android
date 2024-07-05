package com.mirabo_global.hk_cao.util
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

@Composable
fun ScreenHeightInDp(): Float {
    val configuration = LocalConfiguration.current
    val screenHeightPx = configuration.screenHeightDp.dp

    val density = LocalDensity.current
    val screenHeightDp = with(density) { screenHeightPx.toPx() / density.density }

    return screenHeightDp
}