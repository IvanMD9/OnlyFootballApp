package com.example.footballapp.presentation.chempinship.team_matches.ligue_1

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.utils.baseui.BaseTeamMatchesWindow

@Composable
fun TeamMatchesLigue1Window() {
    val viewModel: TeamMatchesLigue1ViewModel = hiltViewModel()
    BaseTeamMatchesWindow(viewModel = viewModel)
}