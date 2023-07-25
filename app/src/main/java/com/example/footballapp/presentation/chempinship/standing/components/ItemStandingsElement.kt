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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import coil.size.Size
import com.example.footballapp.R
import com.example.footballapp.domain.model.standing.TableModel
import com.example.footballapp.presentation.constants.StatisticsItemTextStanding
import com.example.footballapp.utils.AppDimensions

@Composable
fun ItemStandingsInfo(
    table: TableModel,
    modifier: Modifier = Modifier,
) {
    val imageStanding = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .decoderFactory(SvgDecoder.Factory())
            .data(table.team.crest)
            .size(Size.ORIGINAL)
            .build()
    )
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                vertical = dimensionResource(id = R.dimen.vertical_padding_pre_small),
                horizontal = dimensionResource(id = R.dimen.horizontal_padding_pre_medium),
            ),
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
                fontSize = AppDimensions.Text.lineHeightTextS,
                color = colorResource(id = R.color.colorBlack),
            )
            Spacer(
                modifier = Modifier
                    .width(
                        width = dimensionResource(id = R.dimen.horizontal_padding_pre_small)
                    ),
            )
            Image(
                painter = imageStanding,
                contentDescription = null,
                modifier = Modifier.size(35.dp)
            )
            Spacer(
                modifier = Modifier
                    .width(
                        width = dimensionResource(id = R.dimen.horizontal_padding_pre_small)
                    ),
            )
            Text(
                text = table.team.shortName,
                fontSize = AppDimensions.Text.lineHeightTextS,
                color = colorResource(id = R.color.colorBlack),
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.weight(2.5f)
        ) {
            Spacer(
                modifier = Modifier
                    .width(
                        width = dimensionResource(id = R.dimen.horizontal_padding_small)
                    ),
            )
            StatisticsItemTextStanding(
                text = "${table.playedGames}",
                fontWeight = FontWeight.Light
            )
            Spacer(
                modifier = Modifier
                    .width(
                        width = dimensionResource(id = R.dimen.horizontal_padding_small)
                    ),
            )
            StatisticsItemTextStanding(
                text = "${table.won}",
                fontWeight = FontWeight.Light
            )
            Spacer(
                modifier = Modifier
                    .width(
                        width = dimensionResource(id = R.dimen.horizontal_padding_small)
                    ),
            )
            StatisticsItemTextStanding(
                text = "${table.draw}",
                fontWeight = FontWeight.Light
            )
            Spacer(
                modifier = Modifier
                    .width(
                        width = dimensionResource(id = R.dimen.horizontal_padding_small)
                    ),
            )
            StatisticsItemTextStanding(
                text = "${table.lost}",
                fontWeight = FontWeight.Light
            )
            Spacer(
                modifier = Modifier
                    .width(
                        width = dimensionResource(id = R.dimen.horizontal_padding_small)
                    ),
            )
            StatisticsItemTextStanding(
                text = "${table.goalsFor}:${table.goalsAgainst}",
                fontWeight = FontWeight.Light
            )
            Spacer(
                modifier = Modifier
                    .width(
                        width = dimensionResource(id = R.dimen.horizontal_padding_small)
                    ),
            )
            StatisticsItemTextStanding(
                text = "${table.goalDifference}",
                fontWeight = FontWeight.Light
            )
            Spacer(
                modifier = Modifier
                    .width(
                        width = dimensionResource(id = R.dimen.horizontal_padding_small)
                    ),
            )
            StatisticsItemTextStanding(
                text = "${table.points}",
                fontWeight = FontWeight.Bold
            )
        }
    }
}