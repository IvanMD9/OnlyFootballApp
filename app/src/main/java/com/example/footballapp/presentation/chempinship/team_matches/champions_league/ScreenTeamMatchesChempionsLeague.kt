package com.example.footballapp.presentation.chempinship.team_matches.champions_league

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.presentation.chempinship.team_matches.components.ItemTeamMatches

@Composable
fun TeamMatchesChampionsLeagueWindow(
    viewModel: TeamMatchesChampionsLeagueViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            state.value.data?.let {
                items(it.matches) { result ->
                    ItemTeamMatches(teamMatches = result)
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