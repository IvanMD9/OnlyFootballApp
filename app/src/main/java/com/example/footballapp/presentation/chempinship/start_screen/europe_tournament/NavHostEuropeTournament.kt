package com.example.footballapp.presentation.chempinship.start_screen.europe_tournament

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.footballapp.presentation.chempinship.MainWindowChampionsLeague

@ExperimentalFoundationApi
@Composable
fun NavHostEuropeTournament(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ScreenEuropeTournament.EuropeTournamentAll.route
    ) {
        composable(route = ScreenEuropeTournament.EuropeTournamentAll.route) {
            EuropeTournamentWindow(navController = navController)
        }
        composable(route = ScreenEuropeTournament.ChampionScreen.route) {
            MainWindowChampionsLeague()
        }
    }
}