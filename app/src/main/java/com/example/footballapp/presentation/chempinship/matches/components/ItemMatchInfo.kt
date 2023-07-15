package com.example.footballapp.presentation.chempinship.matches.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
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
import com.example.footballapp.domain.model.matches.Matches
import com.example.footballapp.presentation.constants.ItemResultMatch

@Composable
fun ItemMatch(
    match: Matches
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        shape = RoundedCornerShape(10.dp),
        backgroundColor = Color.White,
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ItemClub(
                image = match.homeTeam.crest,
                name = match.homeTeam.shortName
            )
            ItemResultMatch(
                goalHome = match.score.fullTime.home,
                goalAway = match.score.fullTime.away,
                goalHomeRegular = match.score.regularTime?.home?.plus(
                    match.score.extraTime?.home ?: 0
                ),
                goalAwayRegular = match.score.regularTime?.away?.plus(
                    match.score.extraTime?.away ?: 0
                ),
                goalHomePen = match.score.penalties?.home,
                goalAwayPen = match.score.penalties?.away,
            )
            ItemClub(
                image = match.awayTeam.crest,
                name = match.awayTeam.shortName
            )
        }
    }
}

@Composable
private fun ItemClub(
    image: String?,
    name: String?
) {
    val itemClub = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .decoderFactory(SvgDecoder.Factory())
            .data(image)
            .build()
    )
    Column(
        modifier = Modifier.width(115.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = itemClub,
            contentDescription = null,
            modifier = Modifier
                .size(35.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = name.orEmpty(),
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black,
            maxLines = 1
        )
    }
}