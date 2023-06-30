package com.example.footballapp.presentation.chempinship.standing.champions_league.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.footballapp.data.model.chempionship.standing.Table
import com.example.footballapp.presentation.constants.StatisticsItemTextStanding

@Composable
fun ItemStandingEurope(
    table: Table
) {
    val imageStanding = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .decoderFactory(SvgDecoder.Factory())
            .data(table.team.crest)
            .build()
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(2f)
        ) {
            Text(
                text = table.position.toString(),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
            Spacer(modifier = Modifier.width(6.dp))
            Image(
                painter = imageStanding,
                contentDescription = null,
                modifier = Modifier.size(35.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = table.team.shortName,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.weight(2.1f)
        ) {
            StatisticsItemTextStanding(text = table.playedGames.toString(), fontWeight = FontWeight.Light)
            StatisticsItemTextStanding(text = table.won.toString(), fontWeight = FontWeight.Light)
            StatisticsItemTextStanding(text = table.draw.toString(), fontWeight = FontWeight.Light)
            StatisticsItemTextStanding(text = table.lost.toString(), fontWeight = FontWeight.Light)
            StatisticsItemTextStanding(text = "${table.goalsFor}:${table.goalsAgainst}", fontWeight = FontWeight.Light)
            StatisticsItemTextStanding(text = table.goalDifference.toString(), fontWeight = FontWeight.Light)
            StatisticsItemTextStanding(text = table.points.toString(), fontWeight = FontWeight.Bold)
        }
    }
}