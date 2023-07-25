package com.example.footballapp.presentation.constants

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.footballapp.R
import com.example.footballapp.utils.AppDimensions

@Composable
fun HeaderStatisticsStanding(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = colorResource(id = R.color.white)
            )
            .padding(
                start = dimensionResource(id = R.dimen.horizontal_padding_pre_medium),
                end = dimensionResource(id = R.dimen.horizontal_padding_pre_medium),
                top = dimensionResource(id = R.dimen.vertical_padding_small),
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.weight(2f)
        ) {
            TextHeaderStatistics(text = stringResource(id = R.string.app_standing_statistics_club))
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.weight(2.2f)
        ) {
            TextHeaderStatistics(text = stringResource(id = R.string.app_standing_statistics_matches))
            TextHeaderStatistics(text = stringResource(id = R.string.app_standing_statistics_win))
            TextHeaderStatistics(text = stringResource(id = R.string.app_standing_statistics_draw))
            TextHeaderStatistics(text = stringResource(id = R.string.app_standing_statistics_lose))
            TextHeaderStatistics(text = stringResource(id = R.string.app_standing_statistics_goals))
            TextHeaderStatistics(text = stringResource(id = R.string.app_standing_statistics_difference))
            TextHeaderStatistics(text = stringResource(id = R.string.app_standing_statistics_points))
        }
    }
}

@Composable
private fun TextHeaderStatistics(
    text: String
) {
    Text(
        text = text,
        fontSize = AppDimensions.Text.textM,
        fontWeight = FontWeight.Medium,
        color = colorResource(id = R.color.colorGray)
    )
}