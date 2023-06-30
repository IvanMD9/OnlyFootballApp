package com.example.footballapp.presentation.chempinship.detail_team.eredivisie

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.footballapp.presentation.chempinship.navigation.NavigationScreen
import com.example.footballapp.utils.baseui.BaseTeamDetailWindow

@Composable
fun TeamDetailEredivisieWindow(
    navController: NavController
) {
    val viewModel: TeamDetailEredivisieViewModel = hiltViewModel()

    BaseTeamDetailWindow(
        viewModel = viewModel,
        onClick = {
            navController.navigate(
                route = NavigationScreen.TeamMatchesScreen.route + "/${viewModel.state.value.data?.id}"
            )
        }
    )
}