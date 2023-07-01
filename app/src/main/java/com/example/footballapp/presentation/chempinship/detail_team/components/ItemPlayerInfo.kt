package com.example.footballapp.presentation.chempinship.detail_team.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footballapp.domain.model.detail_team.Squad

@Composable
fun ItemPlayer(
    player: Squad
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(bottom = 8.dp)
    ) {
        Text(
            text = "Имя: ${player.name}",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Позиция: ${player.position}",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Национальность: ${player.nationality}",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Gray
        )
    }
}