package com.example.footballapp.presentation.chempinship.start_screen.europe_tournament

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.footballapp.presentation.chempinship.start_screen.CardChampionship

@ExperimentalFoundationApi
@Composable
fun EuropeTournamentWindow(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(10.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(items = CardTournamentEurope.values()) { item ->
                CardChampionship(
                    image = item.image,
                    onItemClick = {
                        when (item.id) {
                            CardTournamentEurope.CHAMPIONS.id -> navController.navigate(ScreenEuropeTournament.ChampionScreen.route)
                        }
                    }
                )
            }
        }
    }
}