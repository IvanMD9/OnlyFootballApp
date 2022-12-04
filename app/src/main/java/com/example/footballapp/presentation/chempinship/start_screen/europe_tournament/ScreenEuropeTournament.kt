package com.example.footballapp.presentation.chempinship.start_screen.europe_tournament

sealed class ScreenEuropeTournament(val route : String) {
    object EuropeTournamentAll : ScreenEuropeTournament("all_europe_screen")
    object ChampionScreen : ScreenEuropeTournament("champion_screen")
}
