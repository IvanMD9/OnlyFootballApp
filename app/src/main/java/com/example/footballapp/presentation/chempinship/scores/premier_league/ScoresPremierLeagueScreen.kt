package com.example.footballapp.presentation.chempinship.scores.premier_league

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.presentation.chempinship.scores.components.ItemScoresInfo

@Composable
fun ScoresPremierLeagueScreen(
    viewModel: ScoresPremierLeagueInfoViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            state.value.data?.let {
                items(it.scorers) { result ->
                    ItemScoresInfo(scorer = result)
                    Divider(Modifier.height(1.dp))
                }
            }
        }
        if (state.value.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Color.Black
            )
        }
    }
}