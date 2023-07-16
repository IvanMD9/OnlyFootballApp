package com.example.footballapp.presentation.chempinship.scores.ligue_1

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.utils.baseui.BaseScorersWindow

@Composable
fun ScoresLigue1Screen() {
    val viewModel: ScoresLigue1InfoViewModel = hiltViewModel()
    BaseScorersWindow(viewModel = viewModel)
}