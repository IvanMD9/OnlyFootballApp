package com.example.footballapp.presentation.chempinship.start_screen.world_cup

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
fun WorldCupWindow(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(CardTournamentModel()) }
    val listCard: List<CardTournamentModel> = listOf(
        CardTournamentModel(id = 1, image = R.drawable.qatar)
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
                            1 -> navController.navigate(ScreenWorldCup.QatarWC.route)
                        }
                    }
                )
            }
        }
    }
}