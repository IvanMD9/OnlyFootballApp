package com.example.footballapp.presentation.chempinship.standing.eredivisie

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.utils.baseui.BaseStandingWindow

@ExperimentalFoundationApi
@Composable
fun StandingsEredivisieScreen() {
    val viewModel: StandingsEredivisieInfoViewModel = hiltViewModel()
    BaseStandingWindow(viewModel = viewModel)
}
