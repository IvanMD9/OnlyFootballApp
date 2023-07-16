package com.example.footballapp.presentation.chempinship.teams.champions_league

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.footballapp.utils.baseui.BaseTeamsWindow

@Composable
fun TeamsChampionsLeagueWindow(
    navController: NavController
) {
    val viewModel: TeamsChampionsLeagueInfoViewModel = hiltViewModel()

    BaseTeamsWindow(
        viewModel = viewModel,
        navController = navController,
    )
}