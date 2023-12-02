package com.example.footballapp.presentation.constants

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ItemResultMatch(
    goalHome: Int,
    goalAway: Int,
    goalHomeRegular: Int?,
    goalAwayRegular: Int?,
    goalHomePen: Int?,
    goalAwayPen: Int?,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        if (goalHomeRegular != null && goalAwayRegular != null) {
            Text(
                text = "$goalHomeRegular  -  $goalAwayRegular",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.wrapContentWidth()
            )
        } else {
            Text(
                text = "$goalHome  -  $goalAway",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.wrapContentWidth()
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        if (goalAwayPen != null && goalHomePen != null) {
            Text(
                text = "( $goalHomePen : $goalAwayPen )",
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Gray
            )
        }
    }
}