package com.example.footballapp.presentation.chempinship.navigation

sealed class NavigationScreen(val route : String) {
    object TeamsScreen : NavigationScreen(TEAMS_SCREEN)
    object TeamDetailScreen : NavigationScreen(TEAM_DETAIL_SCREEN)
    object TeamMatchesScreen : NavigationScreen(TEAM_MATCHES_SCREEN)

    companion object {
        const val TEAMS_SCREEN = "teams_screen"
        const val TEAM_DETAIL_SCREEN = "team_detail_screen"
        const val TEAM_MATCHES_SCREEN = "team_matches_screen"
    }
}
