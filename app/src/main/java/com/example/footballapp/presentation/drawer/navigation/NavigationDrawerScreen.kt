package com.example.footballapp.presentation.drawer.navigation

sealed class NavigationDrawerScreen(val route : String, val title : String) {
    object ChampionshipScreen : NavigationDrawerScreen("championship_screen", "Europe championship")
    object EuropeTournamentScreen : NavigationDrawerScreen("test_screen", "Europe tournament")
    object WorldCupScreen : NavigationDrawerScreen("world_cup_screen", "World Cup")
}