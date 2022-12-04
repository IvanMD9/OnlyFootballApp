package com.example.footballapp.presentation.chempinship.start_screen.europe_chempionship

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@ExperimentalFoundationApi
@Composable
fun AllEuropeChampionshipWindow() {
    val navController = rememberNavController()
    NavHostChampionship(navController = navController)
}