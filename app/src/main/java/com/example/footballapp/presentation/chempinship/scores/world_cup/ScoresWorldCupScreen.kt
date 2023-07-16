package com.example.footballapp.presentation.chempinship.scores.world_cup

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.utils.baseui.BaseScorersWindow

@Composable
fun ScoresWorldCupWindow() {
    val viewModel: ScoresWorldCupViewModel = hiltViewModel()
    BaseScorersWindow(viewModel = viewModel)
}