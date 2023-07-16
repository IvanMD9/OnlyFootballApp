package com.example.footballapp.presentation.chempinship.scores.la_liga

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.utils.baseui.BaseScorersWindow

@Composable
fun ScoresLaLigaScreen() {
    val viewModel: ScoresLaLigaInfoViewModel = hiltViewModel()
    BaseScorersWindow(viewModel = viewModel)
}