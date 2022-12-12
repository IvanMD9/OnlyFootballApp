package com.example.footballapp.presentation.drawer.navigation

sealed class NavigationDrawerScreen(val route : String, val title : String) {
    object ChampionshipScreen : NavigationDrawerScreen(ROUTE_CHAMP_SCREEN, TITLE_CHAMP_SCREEN)
    object EuropeTournamentScreen : NavigationDrawerScreen(ROUTE_EUROPE_TOURNAMENT_SCREEN, TITLE_EUROPE_TOURNAMENT_SCREEN)
    object WorldCupScreen : NavigationDrawerScreen(ROUTE_WC_SCREEN, TITLE_WC_SCREEN)

    companion object {
        const val ROUTE_CHAMP_SCREEN = "championship_screen"
        const val ROUTE_EUROPE_TOURNAMENT_SCREEN = "europe_screen"
        const val ROUTE_WC_SCREEN = "world_cup_screen"

        const val TITLE_CHAMP_SCREEN = "Europe championship"
        const val TITLE_EUROPE_TOURNAMENT_SCREEN = "Europe tournament"
        const val TITLE_WC_SCREEN = "World Cup"
    }
}