package com.example.footballapp.presentation.chempinship.teams.eredivisie

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.footballapp.utils.baseui.BaseTeamsWindow

@Composable
fun TeamsEredivisieWindow(
    navController: NavController
) {
    val viewModel: TeamsEredivisieInfoViewModel = hiltViewModel()

    BaseTeamsWindow(
        viewModel = viewModel,
        navController = navController,
    )
}