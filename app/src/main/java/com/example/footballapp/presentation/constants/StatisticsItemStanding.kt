package com.example.footballapp.presentation.constants

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun StatisticsItemTextStanding(
    text: String,
    fontWeight: FontWeight
) {
    Text(
        text = text,
        fontSize = 16.sp,
        color = Color.Black,
        fontWeight = fontWeight
    )
}