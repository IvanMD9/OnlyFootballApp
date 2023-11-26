package com.example.footballapp.utils.baseui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.footballapp.R
import com.example.footballapp.domain.model.standing.StandingsModel
import com.example.footballapp.presentation.chempinship.standing.components.ItemStandingsInfo
import com.example.footballapp.presentation.constants.HeaderStatisticsStanding
import com.example.footballapp.utils.AppDimensions
import com.example.footballapp.utils.base.BaseViewModel

@ExperimentalFoundationApi
@Composable
inline fun <reified ViewModel : BaseViewModel<StandingsModel>> BaseStandingEuropeWindow(
    viewModel: ViewModel,
    modifier: Modifier = Modifier,
) {
    val state = viewModel.state.collectAsState()
    val grouped = state.value.data?.standings?.groupBy { group ->
        group.group
    }

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            grouped?.forEach { (group, clubList) ->
                stickyHeader {
                    Text(
                        text = "$group",
                        color = colorResource(id = R.color.colorBlack),
                        fontSize = AppDimensions.Text.displayM,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = colorResource(id = R.color.white)
                            )
                            .padding(
                                vertical = dimensionResource(id = R.dimen.vertical_padding_pre_small),
                                horizontal = dimensionResource(id = R.dimen.horizontal_padding_pre_medium),
                            )

                    )
                    HeaderStatisticsStanding()
                    Divider(
                        modifier = Modifier.padding(
                            horizontal = dimensionResource(id = R.dimen.horizontal_padding_pre_medium)
                        ),
                        color = Color.LightGray
                    )
                }
                items(clubList) { result ->
                    result.table.forEach { table ->
                        ItemStandingsInfo(table = table)
                        Divider(
                            modifier = Modifier.padding(
                                horizontal = dimensionResource(id = R.dimen.horizontal_padding_pre_medium)
                            ),
                            color = Color.LightGray
                        )
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