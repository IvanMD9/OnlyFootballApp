package com.example.footballapp.presentation.chempinship.team_matches.primeira

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.utils.baseui.BaseTeamMatchesWindow

@Composable
fun TeamMatchesPrimeiraLigaWindow() {
    val viewModel: TeamMatchesPrimeiraViewModel = hiltViewModel()
    BaseTeamMatchesWindow(viewModel = viewModel)
}