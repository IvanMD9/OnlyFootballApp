package com.example.footballapp.presentation.chempinship.standing.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import coil.size.Size
import com.example.footballapp.domain.model.standing.TableModel
import com.example.footballapp.presentation.constants.StatisticsItemTextStanding

@Composable
fun ItemStandingsInfo(
    table: TableModel
) {
    val imageStanding = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .decoderFactory(SvgDecoder.Factory())
            .data(table.team.crest)
            .size(Size.ORIGINAL)
            .build()
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp, horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(2f)
        ) {
            Text(
                text = "${table.position}.",
                fontSize = 16.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.width(6.dp))
            Image(
                painter = imageStanding,
                contentDescription = null,
                modifier = Modifier.size(35.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = table.team.shortName,
                fontSize = 16.sp,
                color = Color.Black
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.weight(2.5f)
        ) {
            Spacer(modifier = Modifier.width(8.dp))
            StatisticsItemTextStanding(text = "${table.playedGames}", fontWeight = FontWeight.Light)
            Spacer(modifier = Modifier.width(8.dp))
            StatisticsItemTextStanding(text = "${table.won}", fontWeight = FontWeight.Light)
            Spacer(modifier = Modifier.width(8.dp))
            StatisticsItemTextStanding(text = "${table.draw}", fontWeight = FontWeight.Light)
            Spacer(modifier = Modifier.width(8.dp))
            StatisticsItemTextStanding(text = "${table.lost}", fontWeight = FontWeight.Light)
            Spacer(modifier = Modifier.width(8.dp))
            StatisticsItemTextStanding(text = "${table.goalsFor}:${table.goalsAgainst}", fontWeight = FontWeight.Light)
            Spacer(modifier = Modifier.width(8.dp))
            StatisticsItemTextStanding(text = "${table.goalDifference}", fontWeight = FontWeight.Light)
            Spacer(modifier = Modifier.width(8.dp))
            StatisticsItemTextStanding(text = "${table.points}", fontWeight = FontWeight.Bold)
        }
    }
}