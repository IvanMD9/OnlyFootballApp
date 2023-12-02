package com.example.footballapp.utils.baseui.tabrow

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.footballapp.utils.AppDimensions

@Composable
fun AppTabContent(
    titleRes: Int,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
) {
    val titleColor = if (isSelected) {
        Color.Black
    } else {
        Color.Gray
    }

    Text(
        text = stringResource(id = titleRes),
        fontSize = AppDimensions.Text.textM,
        fontWeight = FontWeight.Medium,
        maxLines = 1,
        textAlign = TextAlign.Center,
        // TODO: Разобраться с межбуквенным растоянием
        style = TextStyle(letterSpacing = (-1).sp),
        color = titleColor,
        modifier = modifier,
    )
}