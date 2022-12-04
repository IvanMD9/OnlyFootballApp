package com.example.footballapp.presentation.drawer.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.footballapp.presentation.chempinship.start_screen.europe_chempionship.AllEuropeChampionshipWindow
import com.example.footballapp.presentation.chempinship.start_screen.europe_tournament.AllEuropeTournamentWindow
import com.example.footballapp.presentation.chempinship.start_screen.world_cup.CurrentWorldCupWindow

@ExperimentalFoundationApi
@Composable
fun NavHostDrawer(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = NavigationDrawerScreen.ChampionshipScreen.route
    ) {
        composable(route = NavigationDrawerScreen.ChampionshipScreen.route) {
            AllEuropeChampionshipWindow()
        }
        composable(route = NavigationDrawerScreen.EuropeTournamentScreen.route) {
            AllEuropeTournamentWindow()
        }
        composable(route = NavigationDrawerScreen.WorldCupScreen.route) {
            CurrentWorldCupWindow()
        }
    }
}