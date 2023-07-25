package com.example.footballapp.presentation.constants

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.footballapp.R
import com.example.footballapp.utils.AppDimensions

@Composable
fun StatisticsItemTextStanding(
    text: String,
    fontWeight: FontWeight
) {
    Text(
        text = text,
        fontSize = AppDimensions.Text.lineHeightTextS,
        color = colorResource(id = R.color.colorBlack),
        fontWeight = fontWeight
    )
}