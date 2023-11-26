package com.example.footballapp.utils.baseui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.footballapp.R
import com.example.footballapp.domain.model.matches.MatchesModel
import com.example.footballapp.presentation.chempinship.matches.components.ItemMatch
import com.example.footballapp.utils.AppDimensions
import com.example.footballapp.utils.base.BaseViewModel

@ExperimentalFoundationApi
@Composable
inline fun <reified ViewModel : BaseViewModel<MatchesModel>> BaseMatchesWindow(
    viewModel: ViewModel,
    modifier: Modifier = Modifier,
) {
    val state = viewModel.state.collectAsState()

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        // TODO: Для ЛЧ нужно добавить стадию, инчае некорректно отображаются матчи
        val grouped = state.value.data?.matches?.groupBy { matches ->
            matches.matchday
        }
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            grouped?.forEach { (matchDay, matches) ->
                stickyHeader {
                    Text(
                        text = "${stringResource(id = R.string.app_matches_matchday)} $matchDay",
                        fontSize = AppDimensions.Text.displayM,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.colorBlack),
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = colorResource(id = R.color.white)
                            ),
                        textAlign = TextAlign.Center
                    )
                    Spacer(
                        modifier = Modifier.height(
                            height = dimensionResource(id = R.dimen.vertical_padding_small)
                        )
                    )
                }
                items(matches) { result ->
                    ItemMatch(match = result)
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