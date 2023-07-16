package com.example.footballapp.presentation.chempinship.teams.budesliga

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.footballapp.utils.baseui.BaseTeamsWindow

@Composable
fun TeamsBundesligaWindow(
    navController: NavController
) {
    val viewModel: TeamsBundesligaInfoViewModel = hiltViewModel()

    BaseTeamsWindow(
        viewModel = viewModel,
        navController = navController,
    )
}