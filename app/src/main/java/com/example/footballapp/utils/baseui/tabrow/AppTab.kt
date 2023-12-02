package com.example.footballapp.utils.baseui.tabrow

import androidx.compose.material.Tab
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun AppTab(
    titleRes: Int,
    isSelected: Boolean,
    onTabClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Tab(
        modifier = modifier,
        selected = isSelected,
        onClick = onTabClick,
        text = {
            AppTabContent(
                titleRes = titleRes,
                isSelected = isSelected
            )
        },
        selectedContentColor = Color.Black,
        unselectedContentColor = Color.Transparent,
    )
}