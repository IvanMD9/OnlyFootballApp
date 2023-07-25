package com.example.footballapp.presentation.chempinship.standing.premier_league

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.utils.baseui.BaseStandingWindow

@ExperimentalFoundationApi
@Composable
fun StandingsPremierLeagueScreen() {
    val viewModel: StandingsPremierLeagueInfoViewModel = hiltViewModel()
    BaseStandingWindow(viewModel = viewModel)
}
