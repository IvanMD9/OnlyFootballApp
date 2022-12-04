package com.example.footballapp.presentation.chempinship.standing.world_cup

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.presentation.chempinship.standing.champions_league.components.ItemStandingEurope
import com.example.footballapp.presentation.constants.HeaderStatisticsStanding

@ExperimentalFoundationApi
@Composable
fun StandingWorldCupWindow(
    viewModel: StandingWorldCupViewModel = hiltViewModel()
) {
    val stateChampions = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        val grouped = stateChampions.europeStanding?.standings?.groupBy { it.group }
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(bottom = 12.dp)
        ) {
            grouped?.forEach { (group, clubList) ->
                stickyHeader {
                    Text(
                        text = group,
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                    )
                    HeaderStatisticsStanding()
                    Divider(
                        modifier = Modifier.padding(horizontal = 10.dp),
                        color = Color.LightGray
                    )
                }
                items(clubList) { result ->
                    result.table.forEach {
                        ItemStandingEurope(table = it)
                        Divider(
                            modifier = Modifier.padding(horizontal = 10.dp),
                            color = Color.LightGray
                        )
                    }
                }
            }
        }
        if (stateChampions.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Color.Black
            )
        }
    }
}