package com.example.footballapp.presentation.chempinship.team_matches.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import com.example.footballapp.R
import coil.request.ImageRequest
import com.example.footballapp.domain.model.matches.Matches
import com.example.footballapp.presentation.constants.ItemResultMatch
import com.example.footballapp.utils.AppDimensions
import java.text.SimpleDateFormat
import java.util.Date

@Composable
fun ItemTeamMatches(
    teamMatches: Matches,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "${stringResource(id = R.string.app_matches_matchday)} ${teamMatches.matchday}",
            fontSize = AppDimensions.Text.displayM,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.colorBlack),
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "${stringResource(id = R.string.app_team_matches_date)} ${dateFormatter(date = teamMatches.utcDate)}",
            fontSize = AppDimensions.Text.lineHeightTextS,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.colorBlack),
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "${stringResource(id = R.string.app_team_matches_time)} ${timeFormatter(time = teamMatches.utcDate)}",
            fontSize = AppDimensions.Text.lineHeightTextS,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.colorBlack),
        )
        Spacer(modifier = Modifier.height(6.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 12.dp,
                    end = 12.dp,
                    bottom = 10.dp,
                ),
            shape = RoundedCornerShape(10.dp),
            backgroundColor = colorResource(id = R.color.white),
            elevation = 8.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 12.dp,
                        vertical = 12.dp,
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ItemClub(
                    image = teamMatches.homeTeam.crest,
                    name = teamMatches.homeTeam.shortName,
                )
                ItemResultMatch(
                    goalHome = teamMatches.score.fullTime.home,
                    goalAway = teamMatches.score.fullTime.away,
                    goalHomeRegular = teamMatches.score.regularTime?.home?.plus(
                        teamMatches.score.extraTime?.home ?: 0
                    ),
                    goalAwayRegular = teamMatches.score.regularTime?.away?.plus(
                        teamMatches.score.extraTime?.away ?: 0
                    ),
                    goalHomePen = teamMatches.score.penalties?.home,
                    goalAwayPen = teamMatches.score.penalties?.away,
                )
                ItemClub(
                    image = teamMatches.awayTeam.crest,
                    name = teamMatches.awayTeam.shortName,
                )
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
            modifier = Modifier.size(
                size = dimensionResource(id = R.dimen.icon_size_pre_medium)
            ),
        )
        Spacer(
            modifier = Modifier.height(
                height = dimensionResource(id = R.dimen.vertical_padding_smallest)
            ),
        )
        Text(
            text = name,
            fontSize = AppDimensions.Text.lineHeightTextS,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.colorBlack),
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
    return initDate?.let { dateTime ->
        formatter.format(dateTime)
    }.orEmpty()
}

@SuppressLint("SimpleDateFormat")
@Composable
private fun timeFormatter(
    time: String
): String {
    val initDate: Date? = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(time)
    val formatter = SimpleDateFormat("HH:mm")
    return initDate?.let { dateTime ->
        formatter.format(dateTime)
    }.orEmpty()
}