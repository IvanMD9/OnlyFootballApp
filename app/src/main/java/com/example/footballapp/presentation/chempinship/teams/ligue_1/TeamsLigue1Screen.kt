package com.example.footballapp.presentation.chempinship.teams.ligue_1

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.footballapp.utils.baseui.BaseTeamsWindow

@Composable
fun TeamsLigue1Window(
    navController: NavController
) {
    val viewModel: TeamsLigue1InfoViewModel = hiltViewModel()

    BaseTeamsWindow(
        viewModel = viewModel,
        navController = navController,
    )
}