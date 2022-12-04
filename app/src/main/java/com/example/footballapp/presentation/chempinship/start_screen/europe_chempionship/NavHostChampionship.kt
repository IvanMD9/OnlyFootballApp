package com.example.footballapp.presentation.chempinship.start_screen.europe_chempionship

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.footballapp.presentation.chempinship.*

@ExperimentalFoundationApi
@Composable
fun NavHostChampionship(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ScreenChampionship.ChampionAll.route
    ) {
        composable(route = ScreenChampionship.ChampionAll.route) {
            ChampionshipsWindow(navController = navController)
        }
        composable(route = ScreenChampionship.EnglandScreen.route) {
            MainWindowPremierLeague()
        }
        composable(route = ScreenChampionship.GermanyScreen.route) {
            MainWindowBundesliga()
        }
        composable(route = ScreenChampionship.ItalyScreen.route) {
            MainWindowSerieA()
        }
        composable(route = ScreenChampionship.FranceScreen.route) {
            MainWindowLigue1()
        }
        composable(route = ScreenChampionship.SpainScreen.route) {
            MainWindowLaLiga()
        }
        composable(route = ScreenChampionship.PortugalScreen.route) {
            MainWindowPrimeiraLiga()
        }
        composable(route = ScreenChampionship.NetherlandsScreen.route) {
            MainWindowEredivisie()
        }
    }
}