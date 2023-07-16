package com.example.footballapp.presentation.chempinship.team_matches.serie_a

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.utils.baseui.BaseTeamMatchesWindow

@Composable
fun TeamMatchesSerieAWindow() {
    val viewModel: TeamMatchesSerieAViewModel = hiltViewModel()
    BaseTeamMatchesWindow(viewModel = viewModel)
}