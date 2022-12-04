package com.example.footballapp.presentation.chempinship.start_screen.europe_chempionship

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.footballapp.R
import com.example.footballapp.presentation.chempinship.start_screen.CardChampionship
import com.example.footballapp.presentation.chempinship.start_screen.CardTournamentModel

@ExperimentalFoundationApi
@Composable
fun ChampionshipsWindow(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(CardTournamentModel()) }
    val listCard: List<CardTournamentModel> = listOf(
        CardTournamentModel(id = 1, image = R.drawable.france),
        CardTournamentModel(id = 2, image = R.drawable.italy),
        CardTournamentModel(id = 3, image = R.drawable.england),
        CardTournamentModel(id = 4, image = R.drawable.germany),
        CardTournamentModel(id = 5, image = R.drawable.spain),
        CardTournamentModel(id = 6, image = R.drawable.portugal),
        CardTournamentModel(id = 7, image = R.drawable.netherlands)
    )
    Box(modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(10.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(items = listCard) { item ->
                CardChampionship(
                    item = CardTournamentModel(
                        id = item.id,
                        image = item.image
                    ),
                    onItemClick = {
                        selectedIndex = item
                        when (selectedIndex.id) {
                            1 -> navController.navigate(ScreenChampionship.FranceScreen.route)
                            2 -> navController.navigate(ScreenChampionship.ItalyScreen.route)
                            3 -> navController.navigate(ScreenChampionship.EnglandScreen.route)
                            4 -> navController.navigate(ScreenChampionship.GermanyScreen.route)
                            5 -> navController.navigate(ScreenChampionship.SpainScreen.route)
                            6 -> navController.navigate(ScreenChampionship.PortugalScreen.route)
                            7 -> navController.navigate(ScreenChampionship.NetherlandsScreen.route)
                        }
                    }
                )
            }
        }
    }
}