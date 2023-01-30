
package com.turbosokol.sharedfront.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/***
 *If this code runs it created by Evgenii Sokol.
 *If it doesn’t work, I don’t know who created it.
 ***/

@Composable
internal fun TradingAlchemyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val color = if (darkTheme) DarkColorPalette else LightColorPalette
    MaterialTheme(colors = color, content = content)
}

private val DarkColorPalette = darkColors(
    primary = AppColors.primary,
    onPrimary = AppColors.secondary,
    primaryVariant = AppColors.primary,
    secondary = AppColors.secondaryLighter,
    onSecondary = Color.White,
    secondaryVariant = AppColors.secondaryLighter,
    surface = AppColors.darkGrey51,
    onSurface = Color.White,
    background = AppColors.darkGrey32,
    onBackground = Color.White,
    error = AppColors.orange
)

private val LightColorPalette = lightColors(
    primary = AppColors.primary,
    onPrimary = AppColors.secondary,