package com.example.footballapp.presentation.chempinship.team_matches.la_liga

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.utils.baseui.BaseTeamMatchesWindow

@Composable
fun TeamMatchesLaLigaWindow() {
    val viewModel: TeamMatchesLaLigaViewModel = hiltViewModel()
    BaseTeamMatchesWindow(viewModel = viewModel)
}