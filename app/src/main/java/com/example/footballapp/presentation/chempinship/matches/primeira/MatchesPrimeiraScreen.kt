package com.example.footballapp.presentation.chempinship.matches.primeira

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballapp.utils.baseui.BaseMatchesWindow

@ExperimentalFoundationApi
@Composable
fun MatchesScreenPrimeiraLiga() {
    val viewModel: MatchesPrimeiraInfoViewModel = hiltViewModel()
    BaseMatchesWindow(viewModel = viewModel,
        onSelectMatch = viewModel::selectedMatchDialog,
        onDismiss = viewModel::dismissDialog)
}