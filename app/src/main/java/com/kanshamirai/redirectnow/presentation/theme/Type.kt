package com.kanshamirai.presentation.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.kanshamirai.redirectnow.R


// Define and load Fonts
private val jakartaExtraLight = Font(R.font.plus_jakarta_sans_extralight, FontWeight.W200)
private val jakartaLight = Font(R.font.plus_jakarta_sans_light, FontWeight.W300)
private val jakartaNormal = Font(R.font.plus_jakarta_sans, FontWeight.W400)
private val jakartaMedium = Font(R.font.plus_jakarta_sans_medium, FontWeight.W500)
private val jakartaSemiBold = Font(R.font.plus_jakarta_sans_semibold, FontWeight.W600)
private val jakartaBold = Font(R.font.plus_jakarta_sans_bold, FontWeight.W700)
private val jakartaExtraBold = Font(R.font.plus_jakarta_sans_extrabold, FontWeight.W800)

// Create Font Family
val jakartaFontFamily = FontFamily(
    jakartaExtraLight,
    jakartaLight,
    jakartaNormal,
    jakartaMedium,
    jakartaSemiBold,
    jakartaBold,
    jakartaExtraBold,
)

@Immutable
data class ExtendedTypography(

    val medium16: TextStyle = TextStyle(
        fontFamily = jakartaFontFamily,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 24.sp,
    ),

    val medium12: TextStyle = TextStyle(
        fontFamily = jakartaFontFamily,
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 16.sp,
    ),

    val semiBold16: TextStyle = TextStyle(
        fontFamily = jakartaFontFamily,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 24.sp,
    ),

    val semiBold12: TextStyle = TextStyle(
        fontFamily = jakartaFontFamily,
        fontSize = 12.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 20.sp,
    ),

    val bold16: TextStyle = TextStyle(
        fontFamily = jakartaFontFamily,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 24.sp,
    ),
    val bold24: TextStyle = TextStyle(
        fontFamily = jakartaFontFamily,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 32.sp,
    ),

    val medium14: TextStyle = TextStyle(
        fontFamily = jakartaFontFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 20.sp,
    ),

    val semiBold14: TextStyle = TextStyle(
        fontFamily = jakartaFontFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 20.sp,
    ),
)
