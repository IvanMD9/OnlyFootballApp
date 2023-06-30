package com.example.footballapp.presentation.constants

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.footballapp.presentation.chempinship.navigation.NavigationScreen
@Composable
fun NavGraphForMainScreen(
    navHostController: NavHostController,
    teamsTournament: @Composable () -> Unit,
    teamDetailTournament: @Composable () -> Unit,
    teamMatchesTournament: @Composable () -> Unit,
) {
    NavHost(
        navController = navHostController,
        startDestination = NavigationScreen.TeamsScreen.route
    ) {
        composable(route = NavigationScreen.TeamsScreen.route) {
            teamsTournament()
        }
        composable(route = NavigationScreen.TeamDetailScreen.route + "/{detail_bl1}") {
            teamDetailTournament()
        }
        composable(route = NavigationScreen.TeamMatchesScreen.route + "/{team_matches_bl1}") {
            teamMatchesTournament()
        }
    }
}