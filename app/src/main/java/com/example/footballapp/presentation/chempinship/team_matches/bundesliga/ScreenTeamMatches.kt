package com.example.footballapp.presentation.chempinship.team_matches.bundesliga

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.utils.baseui.BaseTeamMatchesWindow

@Composable
fun TeamMatchesBundesligaWindow() {
    val viewModel: TeamMatchesBundesligaViewModel = hiltViewModel()
    BaseTeamMatchesWindow(viewModel = viewModel)
}