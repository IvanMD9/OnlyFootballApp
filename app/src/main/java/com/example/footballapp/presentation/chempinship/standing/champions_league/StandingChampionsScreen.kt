package com.example.footballapp.presentation.chempinship.standing.champions_league

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.utils.baseui.BaseStandingEuropeWindow

@ExperimentalFoundationApi
@Composable
fun StandingChampionsWindow() {
    val viewModel: StandingChampionsViewModel = hiltViewModel()
    BaseStandingEuropeWindow(viewModel = viewModel)
}