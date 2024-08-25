package com.kanshamirai.presentation.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColors = lightColorScheme(
    primary = Color(0xFF006687),
)

val LocalExtendedColors = staticCompositionLocalOf {
    ExtendedColors()
}

val LocalReplacementTypography = staticCompositionLocalOf {
    ExtendedTypography()
}

val LocalCustomElevation = staticCompositionLocalOf {
    ExtendedDimens()
}

@Composable
fun AppTheme(
    useDarkTheme: Boolean = false,
    dynamicColor: Boolean = false,
    content: @Composable() () -> Unit
) {

    val colors = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (useDarkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        else -> LightColors
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colors.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars =
                useDarkTheme
        }
    }

    MaterialTheme(
        colorScheme = colors,
        content = content,
        typography = Typography()
    )
}

@Composable
fun ExtendedTheme(
    content: @Composable () -> Unit
) {

    val extendedColors = ExtendedColors()
    val extendedTypography = ExtendedTypography()
    val extendedDimens = ExtendedDimens()

    CompositionLocalProvider(
        LocalExtendedColors provides extendedColors,
        LocalReplacementTypography provides extendedTypography,
        LocalCustomElevation provides extendedDimens,
        content = content
    )
}

object ExtendedTheme {
    val colors: ExtendedColors
        @Composable
        get() = LocalExtendedColors.current
    val typography: ExtendedTypography
        @Composable
        get() = LocalReplacementTypography.current
    val dimens: ExtendedDimens
        @Composable
        get() = LocalCustomElevation.current
}