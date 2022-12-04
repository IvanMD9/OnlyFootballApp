package com.example.footballapp.presentation.chempinship.team_matches.components

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import coil.size.Size
import com.example.footballapp.data.model.chempionship.matches_team.Matches
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun ItemTeamMatches(
    teamMatches: Matches
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Тур: ${teamMatches.matchday}",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "Дата матча: ${dateFormatter(date = teamMatches.utcDate)}",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "Время матча: ${timeFormatter(date = teamMatches.utcDate)}",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(6.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, bottom = 10.dp),
            shape = RoundedCornerShape(10.dp),
            backgroundColor = Color.White,
            elevation = 8.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ItemClub(image = teamMatches.homeTeam.crest, name = teamMatches.homeTeam.shortName)
                ItemResultMatch(
                    goalHome = teamMatches.score.fullTime.home,
                    goalAway = teamMatches.score.fullTime.away
                )
                ItemClub(image = teamMatches.awayTeam.crest, name = teamMatches.awayTeam.shortName)
            }
        }
    }
}

@Composable
private fun ItemClub(
    image: String,
    name: String
) {
    val itemClub = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .decoderFactory(SvgDecoder.Factory())
            .data(image)
            .build()
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(115.dp)
    ) {
        Image(
            painter = itemClub,
            contentDescription = null,
            modifier = Modifier.size(35.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = name, fontSize = 16.sp, fontWeight = FontWeight.Medium, color = Color.Black)
    }
}

@Composable
private fun ItemResultMatch(
    goalHome: Int,
    goalAway: Int
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.wrapContentWidth()
    ) {
        Text(
            text = goalHome.toString(),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = " - ",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = goalAway.toString(),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}

@SuppressLint("SimpleDateFormat")
@Composable
private fun dateFormatter(
    date: String
): String {
    val initDate: Date? = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(date)
    val formatter = SimpleDateFormat("dd.MM.yyyy")
    return initDate?.let { formatter.format(it) }.toString()
}

@SuppressLint("SimpleDateFormat")
@Composable
private fun timeFormatter(
    date: String
): String {
    val initDate: Date? = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(date)
    val formatter = SimpleDateFormat("HH:mm")
    return initDate?.let { formatter.format(it) }.toString()
}