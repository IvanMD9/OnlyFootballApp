package com.example.footballapp.presentation.chempinship.scores.premier_league

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.utils.baseui.BaseScorersWindow

@Composable
fun ScoresPremierLeagueScreen() {
    val viewModel: ScoresPremierLeagueInfoViewModel = hiltViewModel()
    BaseScorersWindow(viewModel = viewModel)
}