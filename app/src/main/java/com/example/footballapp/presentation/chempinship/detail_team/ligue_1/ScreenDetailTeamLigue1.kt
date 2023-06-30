package com.example.footballapp.presentation.chempinship.detail_team.ligue_1

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.footballapp.presentation.chempinship.navigation.NavigationScreen
import com.example.footballapp.utils.baseui.BaseTeamDetailWindow

@Composable
fun TeamDetailLigue1Window(
    navController: NavController
) {
    val viewModel: TeamDetailLigue1ViewModel = hiltViewModel()

    BaseTeamDetailWindow(
        viewModel = viewModel,
        onClick = {
            navController.navigate(
                route = NavigationScreen.TeamMatchesScreen.route + "/${viewModel.state.value.data?.id}"
            )
        }
    )
}