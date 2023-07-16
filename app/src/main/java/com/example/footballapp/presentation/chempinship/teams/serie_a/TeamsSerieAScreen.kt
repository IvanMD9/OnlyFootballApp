package com.example.footballapp.presentation.chempinship.teams.serie_a

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.footballapp.utils.baseui.BaseTeamsWindow

@Composable
fun TeamsSerieAWindow(
    navController: NavController
) {
    val viewModel: TeamsSerieAInfoViewModel = hiltViewModel()

    BaseTeamsWindow(
        viewModel = viewModel,
        navController = navController,
    )
}