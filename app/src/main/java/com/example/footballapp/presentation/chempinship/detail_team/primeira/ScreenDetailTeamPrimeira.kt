package com.example.footballapp.presentation.chempinship.detail_team.primeira

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.footballapp.presentation.chempinship.navigation.NavigationScreen
import com.example.footballapp.utils.baseui.BaseTeamDetailWindow

@Composable
fun TeamDetailPrimeiraWindow(
    navController: NavController
) {
    val viewModel: TeamDetailPrimeiraViewModel = hiltViewModel()

    BaseTeamDetailWindow(
        viewModel = viewModel,
        onClick = {
            navController.navigate(
                route = NavigationScreen.TeamMatchesScreen.route + "/${viewModel.state.value.data?.id}"
            )
        }
    )
}