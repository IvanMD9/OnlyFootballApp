package com.example.footballapp.presentation.chempinship.start_screen.world_cup

sealed class ScreenWorldCup(val route : String) {
    object CurrentWorldCup : ScreenWorldCup("current_wc_screen")
    object QatarWC : ScreenWorldCup("qatar_wc_screen")
}
