package com.example.footballapp.presentation.chempinship.team_matches.premier_league

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.utils.baseui.BaseTeamMatchesWindow

@Composable
fun TeamMatchesPremierLeagueWindow() {
    val viewModel: TeamMatchesPremierLeagueViewModel = hiltViewModel()
    BaseTeamMatchesWindow(viewModel = viewModel)
}