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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.footballapp.R
import com.example.footballapp.domain.model.scorers.ScorerModel
import com.example.footballapp.utils.AppDimensions

@Composable
fun ItemScoresInfo(
    scorer: ScorerModel,
    modifier: Modifier = Modifier,
) {
    val itemScores = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .decoderFactory(SvgDecoder.Factory())
            .data(scorer.team.crest)
            .build()
    )
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = 10.dp,
                vertical = dimensionResource(id = R.dimen.vertical_padding_smallest)
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = itemScores,
                contentDescription = null,
                modifier = Modifier
                    .size(
                        size = dimensionResource(id = R.dimen.icon_size_medium)
                    )
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(horizontalAlignment = Alignment.Start) {
                Text(
                    text = scorer.player.name,
                    fontSize = AppDimensions.Text.lineHeightTextS,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.colorBlack),
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = scorer.team.shortName,
                    fontSize = AppDimensions.Text.lineHeightTextS,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.colorGray),
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = "${scorer.goals}",
                fontSize = AppDimensions.Text.lineHeightTextS,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.colorBlack),
            )
        }
    }
}