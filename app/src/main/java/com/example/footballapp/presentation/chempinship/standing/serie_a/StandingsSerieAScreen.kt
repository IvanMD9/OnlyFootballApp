package com.example.footballapp.presentation.chempinship.standing.serie_a

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.utils.baseui.BaseStandingWindow

@ExperimentalFoundationApi
@Composable
fun StandingsSerieAScreen() {
    val viewModel: StandingsSerieAInfoViewModel = hiltViewModel()
    BaseStandingWindow(viewModel = viewModel)
}
