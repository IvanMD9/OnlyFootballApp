package com.example.footballapp.presentation.chempinship.start_screen.europe_tournament

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@ExperimentalFoundationApi
@Composable
fun AllEuropeTournamentWindow() {
    val navController = rememberNavController()
    NavHostEuropeTournament(navController = navController)
}