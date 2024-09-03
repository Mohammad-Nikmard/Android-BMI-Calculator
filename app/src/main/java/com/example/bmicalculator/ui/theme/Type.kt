package com.example.bmicalculator.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.bmicalculator.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

val interRegular = FontFamily(
    Font(R.font.inter_regular)
)

val interMedium = FontFamily(
    Font(R.font.inter_medium)
)

val interBold = FontFamily(
    Font(R.font.inter_bold)
)

val interExtraBoldItalic = FontFamily(
    Font(R.font.inter_extra_bold_italic)
)