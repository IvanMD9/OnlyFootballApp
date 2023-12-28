package com.example.footballapp.utils.baseui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.footballapp.R
import com.example.footballapp.domain.model.scorers.ScorersModel
import com.example.footballapp.presentation.chempinship.scores.components.ItemScoresInfo
import com.example.footballapp.utils.AppDimensions
import com.example.footballapp.utils.base.BaseViewModel

@Composable
inline fun <reified ViewModel : BaseViewModel<ScorersModel>> BaseScorersWindow(
    viewModel: ViewModel,
    modifier: Modifier = Modifier,
) {
    val state = viewModel.state.collectAsState()

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {

        if (state.value.data?.scorers?.isEmpty() == true) {
            Text(
                text = stringResource(id = R.string.app_scorers_empty),
                fontSize = AppDimensions.Text.lineHeightDisplayM,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.colorBlack),
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        vertical = dimensionResource(id = R.dimen.horizontal_padding_medium),
                        horizontal = dimensionResource(id = R.dimen.horizontal_padding_pre_medium),
                    )
            ) {
                state.value.data?.let { scorers ->
                    items(
                        items = scorers.scorers,
                        key = { score -> score.player.id }
                    ) { result ->
                        ItemScoresInfo(
                            image = result.team.crest,
                            namePlayer = result.player.name,
                            shortNameClub = result.team.shortName,
                            goals = result.goals,
                            penalties = result.penalties,
                            assists = result.assists,
                        )
                        Divider(Modifier.height(1.dp))
                    }
                }
            }
        }
        if (state.value.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = colorResource(id = R.color.colorBlack),
            )
        }
    }
}