package com.example.footballapp.presentation.chempinship.scores.bundesliga

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.utils.baseui.BaseScorersWindow

@Composable
fun ScoresBundesligaScreen() {
    val viewModel: ScoresBundesligaInfoViewModel = hiltViewModel()
    BaseScorersWindow(viewModel = viewModel)
}