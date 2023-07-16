package com.example.footballapp.presentation.chempinship.scores.serie_a

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.utils.baseui.BaseScorersWindow

@Composable
fun ScoresSerieAScreen() {
    val viewModel: ScoresSerieAInfoViewModel = hiltViewModel()
    BaseScorersWindow(viewModel = viewModel)
}