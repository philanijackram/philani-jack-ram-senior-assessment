package com.jackslan.taskmanager.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF5E5D5D),
    onPrimary = Color.White,
    secondary = Color(0xFFFDFDFD),
    onSecondary = Color.Black,
    surface = Color(0xFF5E5D5D),
    onSurface = Color.White,
    background = Color.Black,
    onBackground = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFFDFDFD),
    onPrimary = Color.Black,
    secondary = Color(0xFF5E5D5D),
    onSecondary = Color.White,
    surface = Color(0xFFFDFDFD),
    onSurface = Color.Black,
    background = Color.White,
    onBackground = Color.Black
)

@Composable
fun TaskManagerTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )

}