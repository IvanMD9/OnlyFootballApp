package com.example.footballapp.presentation.chempinship.team_matches.eredivisie

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.utils.baseui.BaseTeamMatchesWindow

@Composable
fun TeamMatchesEredivisieWindow() {
    val viewModel: TeamMatchesEredivisieViewModel = hiltViewModel()
    BaseTeamMatchesWindow(viewModel = viewModel)
}