package com.example.footballapp.presentation.chempinship.start_screen.europe_chempionship

sealed class ScreenChampionship(val route : String) {
    object ChampionAll : ScreenChampionship("all_screen")
    object GermanyScreen : ScreenChampionship("germany_screen")
    object EnglandScreen : ScreenChampionship("england_screen")
    object ItalyScreen : ScreenChampionship("italy_screen")
    object FranceScreen : ScreenChampionship("france_screen")
    object SpainScreen : ScreenChampionship("spain_screen")
    object PortugalScreen : ScreenChampionship("portugal_screen")
    object NetherlandsScreen : ScreenChampionship("netherlands_screen")
}
