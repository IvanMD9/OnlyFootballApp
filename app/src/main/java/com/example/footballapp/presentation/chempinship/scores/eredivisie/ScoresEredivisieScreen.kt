package com.example.footballapp.presentation.chempinship.scores.eredivisie

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.utils.baseui.BaseScorersWindow

@Composable
fun ScoresEredivisieScreen() {
    val viewModel: ScoresEredivisieInfoViewModel = hiltViewModel()
    BaseScorersWindow(viewModel = viewModel)
}