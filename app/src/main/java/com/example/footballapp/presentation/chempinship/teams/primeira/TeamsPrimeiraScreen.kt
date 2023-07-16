package com.example.footballapp.presentation.chempinship.teams.primeira

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.footballapp.utils.baseui.BaseTeamsWindow

@Composable
fun TeamsPrimeiraLigaWindow(
    navController: NavController
) {
    val viewModel: TeamsPrimeiraInfoViewModel = hiltViewModel()

    BaseTeamsWindow(
        viewModel = viewModel,
        navController = navController,
    )
}