package com.example.footballapp.presentation.chempinship.team_matches.champions_league

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.utils.baseui.BaseTeamMatchesWindow

@Composable
fun TeamMatchesChampionsLeagueWindow() {
    val viewModel: TeamMatchesChampionsLeagueViewModel = hiltViewModel()
    BaseTeamMatchesWindow(viewModel = viewModel)
}