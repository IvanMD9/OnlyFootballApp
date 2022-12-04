package com.example.footballapp.presentation.chempinship.start_screen.world_cup

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@ExperimentalFoundationApi
@Composable
fun CurrentWorldCupWindow() {
    val navController = rememberNavController()
    NavHostWorldCup(navController = navController)
}