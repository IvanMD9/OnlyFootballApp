package com.example.footballapp.presentation.chempinship.teams.world_cup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.footballapp.presentation.chempinship.teams.components.ItemTeamInfo
import com.example.footballapp.presentation.chempinship.navigation.NavigationScreen

@Composable
fun TeamsWorldCupWindow(
    viewModel: TeamsWorldCupViewModel = hiltViewModel(),
    navController: NavController
) {
    val state = viewModel.state.value
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier.padding(horizontal = 6.dp)
        ) {
            state.teamsInfo?.let {
                items(it.teams) { result ->
                    ItemTeamInfo(team = result, onClickDetailTeam = {
                        navController.navigate(NavigationScreen.TeamDetailScreen.route + "/${result.id}")
                    })
                }
            }
        }
        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Color.Black
            )
        }
    }
}