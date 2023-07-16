package com.example.footballapp.presentation.chempinship.teams.world_cup

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.footballapp.utils.baseui.BaseTeamsWindow

@Composable
fun TeamsWorldCupWindow(
    navController: NavController
) {
    val viewModel: TeamsWorldCupViewModel = hiltViewModel()

    BaseTeamsWindow(
        viewModel = viewModel,
        navController = navController,
    )
}