package com.example.footballapp.presentation.chempinship.standing.ligue_1

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.utils.baseui.BaseStandingWindow

@ExperimentalFoundationApi
@Composable
fun StandingsLigue1Screen() {
    val viewModel: StandingsLigue1InfoViewModel = hiltViewModel()
    BaseStandingWindow(viewModel = viewModel)
}
