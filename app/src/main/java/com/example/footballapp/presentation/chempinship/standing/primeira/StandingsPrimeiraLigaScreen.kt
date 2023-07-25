package com.example.footballapp.presentation.chempinship.standing.primeira

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.utils.baseui.BaseStandingWindow

@ExperimentalFoundationApi
@Composable
fun StandingsPrimeiraLigaScreen() {
    val viewModel: StandingsPrimeiraLigaInfoViewModel = hiltViewModel()
    BaseStandingWindow(viewModel = viewModel)
}
