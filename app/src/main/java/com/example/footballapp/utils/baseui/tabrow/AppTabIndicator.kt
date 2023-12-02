package com.example.footballapp.utils.baseui.tabrow

import androidx.compose.material.TabRowDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AppTabIndicator(
    modifier: Modifier = Modifier,
) {
    TabRowDefaults.Indicator(
        modifier = modifier,
        height = 3.dp,
        color = Color.Red,
    )
}