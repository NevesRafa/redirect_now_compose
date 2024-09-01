package com.kanshamirai.presentation.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class ExtendedColors(
    val transparent: Color = Color(0x00FFFFFF),
    val white: Color = Color(0xFFFFFFFF),
    val black: Color = Color(0xFF000000),
    val darkBlue: Color = Color(0xFF0D0140),
    val lightBlue: Color = Color(0xFFC2BBE0),
    val grayScale700: Color = Color(0xFF777777),
    val red: Color = Color(0xFFF04E55),
    val blackGrayScale: Color = Color(0xFF111111),
    val lightGray: Color = Color(0xFFE3E3E5),
    val frostGray:Color = Color(0xFFE3E3E5),
    val yellow:Color = Color(0xFFFFC107)
)
