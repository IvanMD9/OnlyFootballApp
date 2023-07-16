package com.example.footballapp.presentation.chempinship.scores.champions_league

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.utils.baseui.BaseScorersWindow

@Composable
fun ScoresChampionsLeagueWindow() {
    val viewModel: ScoresChampionsLeagueInfoViewModel = hiltViewModel()
    BaseScorersWindow(viewModel = viewModel)
}