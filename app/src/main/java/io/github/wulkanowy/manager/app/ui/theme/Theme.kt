package io.github.wulkanowy.manager.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val LightColorPalette = lightColors(
    primary = PersianRed
)

@Composable
fun WulkanowyManagerTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val systemUiController = rememberSystemUiController()
    val colors = if (isDarkTheme) {
        LightColorPalette
    } else {
        LightColorPalette
    }

    systemUiController.setSystemBarsColor(Color.White)

    MaterialTheme(
        colors = colors,
        content = content
    )
}
