package com.example.footballapp.presentation.constants

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeaderStatisticsStanding() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(start = 10.dp, end = 10.dp, top = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            horizontalArrangement = Arrangement.Start, modifier = Modifier
                .weight(2f)
        ) {
            TextHeaderStatistics(text = "Клуб")
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.weight(2.2f)
        ) {
            TextHeaderStatistics(text = "M")
            TextHeaderStatistics(text = "W")
            TextHeaderStatistics(text = "D")
            TextHeaderStatistics(text = "L")
            TextHeaderStatistics(text = "Goals")
            TextHeaderStatistics(text = "+/-")
            TextHeaderStatistics(text = "O")
        }
    }
}

@Composable
private fun TextHeaderStatistics(
    text: String
) {
    Text(
        text = text,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        color = Color.Gray
    )
}