package com.example.footballapp.presentation.chempinship.start_screen.world_cup

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.footballapp.presentation.chempinship.*

@ExperimentalFoundationApi
@Composable
fun NavHostWorldCup(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ScreenWorldCup.CurrentWorldCup.route
    ) {
        composable(route = ScreenWorldCup.CurrentWorldCup.route) {
            WorldCupWindow(navController = navController)
        }
        composable(route = ScreenWorldCup.QatarWC.route) {
            MainWindowWorldCup()
        }
    }
}