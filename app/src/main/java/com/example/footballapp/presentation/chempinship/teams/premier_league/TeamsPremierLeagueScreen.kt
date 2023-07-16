package com.example.footballapp.presentation.chempinship.teams.premier_league

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.footballapp.utils.baseui.BaseTeamsWindow

@Composable
fun TeamsPremierLeagueWindow(
    navController: NavController
) {
    val viewModel: TeamsPremierLeagueInfoViewModel = hiltViewModel()

    BaseTeamsWindow(
        viewModel = viewModel,
        navController = navController,
    )
}