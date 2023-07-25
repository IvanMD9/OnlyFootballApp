package com.example.footballapp.presentation.chempinship.standing.bundesliga

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.utils.baseui.BaseStandingWindow

@ExperimentalFoundationApi
@Composable
fun StandingsBundesligaScreen() {
    val viewModel: StandingsBundesligaInfoViewModel = hiltViewModel()
    BaseStandingWindow(viewModel = viewModel)
}
