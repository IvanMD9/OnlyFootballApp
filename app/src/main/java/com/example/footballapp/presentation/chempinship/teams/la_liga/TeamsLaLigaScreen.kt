package com.example.footballapp.presentation.chempinship.teams.la_liga

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.footballapp.utils.baseui.BaseTeamsWindow

@Composable
fun TeamsLaLigaWindow(
    navController: NavController
) {
    val viewModel: TeamsLaLigaInfoViewModel = hiltViewModel()

    BaseTeamsWindow(
        viewModel = viewModel,
        navController = navController,
    )
}