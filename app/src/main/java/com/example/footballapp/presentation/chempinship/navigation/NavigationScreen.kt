package com.example.footballapp.presentation.chempinship.navigation

sealed class NavigationScreen(val route : String) {
    object TeamsScreen : NavigationScreen("teams_screen")
    object TeamDetailScreen : NavigationScreen("team_detail_screen")
    object TeamMatchesScreen : NavigationScreen("team_matches_screen")
}
