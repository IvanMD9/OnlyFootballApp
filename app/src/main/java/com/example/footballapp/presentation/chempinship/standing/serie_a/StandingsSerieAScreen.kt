package com.example.footballapp.presentation.chempinship.standing.serie_a

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.presentation.chempinship.standing.components.ItemStandingsInfo
import com.example.footballapp.presentation.constants.HeaderStatisticsStanding

@ExperimentalFoundationApi
@Composable
fun StandingsSerieAScreen(
    viewModel: StandingsSerieAInfoViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        val grouped = state.standingsInfo?.standings?.groupBy { it.type }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            grouped?.forEach { (type, clubList) ->
                stickyHeader {
                    Text(
                        text = "Набранные очки: $type",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black,
                        modifier = Modifier
                            .background(Color.White)
                            .fillMaxWidth()
                            .padding(vertical = 6.dp, horizontal = 10.dp)
                    )
                    HeaderStatisticsStanding()
                    Divider(
                        modifier = Modifier.padding(horizontal = 10.dp),
                        color = Color.LightGray
                    )
                }
                items(clubList) { result ->
                    result.table.forEach {
                        ItemStandingsInfo(table = it)
                        Divider(
                            modifier = Modifier.padding(horizontal = 10.dp),
                            color = Color.LightGray
                        )
                    }
                }
            }
        }
        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Color.Black
            )
        }
    }
}
