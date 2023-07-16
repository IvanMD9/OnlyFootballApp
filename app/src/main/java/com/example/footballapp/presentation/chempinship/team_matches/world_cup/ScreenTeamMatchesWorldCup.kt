package com.example.footballapp.presentation.chempinship.team_matches.world_cup

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.utils.baseui.BaseTeamMatchesWindow

@Composable
fun TeamMatchesWorldCupWindow() {
    val viewModel: TeamMatchesWorldCupViewModel = hiltViewModel()
    BaseTeamMatchesWindow(viewModel = viewModel)
}