package com.example.footballapp.presentation.chempinship.scores.components

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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.footballapp.R
import com.example.footballapp.ui.theme.FootballAppTheme
import com.example.footballapp.utils.AppDimensions

@Composable
fun ItemScoresInfo(
    image: String,
    namePlayer: String,
    shortNameClub: String,
    goals: Int,
    penalties: Int,
    assists: Int,
    modifier: Modifier = Modifier,
) {
    val imageScores = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .decoderFactory(SvgDecoder.Factory())
            .data(image)
            .build()
    )
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = dimensionResource(id = R.dimen.vertical_padding_pre_small)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.weight(0.6f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = imageScores,
                contentDescription = null,
                modifier = Modifier
                    .size(
                        size = dimensionResource(id = R.dimen.icon_size_pre_medium)
                    )
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(horizontalAlignment = Alignment.Start) {
                Text(
                    text = namePlayer,
                    fontSize = AppDimensions.Text.textM,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.colorBlack),
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = shortNameClub,
                    fontSize = AppDimensions.Text.textM,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.colorGray),
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.4f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column(modifier = Modifier.wrapContentWidth()) {
                Text(
                    text = stringResource(id = R.string.app_scores_goals_and_penalties),
                    fontSize = AppDimensions.Text.textM,
                    fontWeight = FontWeight.Light,
                    color = colorResource(id = R.color.colorBlack),
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = stringResource(id = R.string.app_scores_assists),
                    fontSize = AppDimensions.Text.textM,
                    fontWeight = FontWeight.Light,
                    color = colorResource(id = R.color.colorBlack),
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.wrapContentWidth(),
                horizontalAlignment = Alignment.End,
            ) {
                Text(
                    text = "$goals ($penalties)",
                    fontSize = AppDimensions.Text.textM,
                    fontWeight = FontWeight.Light,
                    color = colorResource(id = R.color.colorBlack),
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "$assists",
                    fontSize = AppDimensions.Text.textM,
                    fontWeight = FontWeight.Light,
                    color = colorResource(id = R.color.colorBlack),
                )
            }
        }
    }
}

@Composable
@Preview
fun ItemScoresInfoPreview() {
    FootballAppTheme {
        ItemScoresInfo(
            image = "",
            namePlayer = "Harry Kane",
            shortNameClub = "Bayern",
            goals = 18,
            penalties = 4,
            assists = 5
        )
    }
}