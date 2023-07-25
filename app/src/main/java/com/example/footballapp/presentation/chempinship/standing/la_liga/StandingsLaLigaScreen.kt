package com.example.footballapp.presentation.chempinship.standing.la_liga

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.utils.baseui.BaseStandingWindow

@ExperimentalFoundationApi
@Composable
fun StandingLaLiagScreen() {
    val viewModel: StandingsLaLigaInfoViewModel = hiltViewModel()
    BaseStandingWindow(viewModel = viewModel)
}
