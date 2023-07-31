package com.example.footballapp.presentation.chempinship.standing.world_cup

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.utils.baseui.BaseStandingEuropeWindow

@ExperimentalFoundationApi
@Composable
fun StandingWorldCupWindow() {
    val viewModel: StandingWorldCupViewModel = hiltViewModel()
    BaseStandingEuropeWindow(viewModel = viewModel)
}